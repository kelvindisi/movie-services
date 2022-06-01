package com.devkiu.rating.resources;

import com.devkiu.rating.models.Rating;
import com.devkiu.rating.models.Ratings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
@Slf4j
public class RatingResource {
    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public Ratings getUserRating(@PathVariable String userId) {
        log.info("RatingController: getting rating for {}", userId);
        List<Rating> ratings = Arrays.asList(
                new Rating("44se", 5),
                new Rating("33ff", 3),
                new Rating("4545", 6)
        );
        return new Ratings(ratings);
    }
}