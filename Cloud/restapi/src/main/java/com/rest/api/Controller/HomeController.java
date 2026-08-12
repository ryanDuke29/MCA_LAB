package com.rest.api.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.Model.Movies;
import com.rest.api.Service.MovieService;

import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/movies")
public class HomeController {
    List<Movies> moviesList = new ArrayList<>();

    private final MovieService service;

    public HomeController(MovieService service) {
        this.service = service;

        moviesList.add(new Movies(1, "The Odyssey", "Action/Fantasy", 8.5));
        moviesList.add(new Movies(2, "spider man brand new day", "Action/Adventure", 8.1));
    }

    @GetMapping("/allMovies")
    public List<Movies> getAllMovies() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/main/resources/data/movies.json"), moviesList);
        System.out.println("file Created");
        return moviesList;
    }

    @GetMapping("/{id}")
    public Movies getMovie(@PathVariable int id) {
        return service.getMovie(id, moviesList);
    }

    @PostMapping("/addMovie")
    public String addMovie(@RequestBody Movies movie) {
        return service.addMovie(movie, moviesList);
    }

    @PutMapping("/{id}")
    public String updateMovie(@PathVariable int id,
            @RequestBody Movies movie) {
        return service.updateMovie(id, movie, moviesList);
    }

    @DeleteMapping("/{id}")
    public String deleteMovieById(@PathVariable int id) {
        return service.deleteMovieById(id, moviesList);
    }
}
