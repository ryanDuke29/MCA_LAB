package com.rest.api.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rest.api.Model.Movies;

@Service
public class MovieService {
    public Movies getMovie(Integer id, List<Movies> moviesList) {

        Movies movie = new Movies(null, null, null, null);
        for (Movies i : moviesList) {
            if (i.getId() == id) {
                movie = i;
                break;
            }
        }
        return movie;
    }

    public String deleteMovieById(Integer id, List<Movies> moviesList) {
        for (Movies i : moviesList) {
            if (i.getId() == id) {
                moviesList.remove(i);
                break;
            }
        }
        return "Done";
    }

    public String addMovie(Movies movie, List<Movies> moviesList) {
        moviesList.add(movie);
        return "Movie Added";
    }

    public String updateMovie(Integer id, Movies updatedMovie, List<Movies> moviesList) {

        for (Movies movie : moviesList) {
            if (movie.getId() == id) {
                movie.setName(updatedMovie.getName());
                movie.setGenre(updatedMovie.getGenre());
                movie.setRating(updatedMovie.getRating());
                return "Movie updated successfully";
            }
        }

        return "Movie not found";
    }

}
