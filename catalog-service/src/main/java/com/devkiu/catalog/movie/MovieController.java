package com.devkiu.catalog.movie;

import com.devkiu.catalog.info.Movie;
import com.devkiu.catalog.rating.Rating;
import com.devkiu.catalog.rating.UserRating;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    private final RestTemplate restTemplate;
    private final WebClient.Builder webBuilder;

    @GetMapping("{userId}")
    public List<CatalogItem> getUserMovies(@PathVariable String userId) {
        log.info("MovieController: getting user movie catalogs for {}", userId);
        // get all rated movies ids
        String ratingsUrl = "http://rating-service/ratingsdata/users/{user}";
        List<Rating> ratings = Objects.requireNonNull(restTemplate.getForObject(ratingsUrl, UserRating.class, userId)).getRatingList();
        // for each movie ID, call movie info service and get details
        String url = "http://info-service/movies/{movieId}";
        return ratings.stream().map(rating -> {
            Movie movieResponse = webBuilder.build().get()
                    .uri(url, rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            assert movieResponse != null;
            return new CatalogItem(movieResponse.getName(), movieResponse.getDescription(), rating.getRating());
        }).collect(Collectors.toList());
    }
}
