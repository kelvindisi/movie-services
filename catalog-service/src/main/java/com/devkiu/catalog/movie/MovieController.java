package com.devkiu.catalog.movie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    private final MovieService movieService;

    @GetMapping("{username}")
    public List<CatalogItem> getUserMovies(@PathVariable String username) {
        log.info("MovieController: getting user movie catalogs for {}", username);
        return null;
    }
}
