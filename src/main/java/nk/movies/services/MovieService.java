package nk.movies.services;

import nk.movies.domain.Movie;

import java.util.List;

public interface MovieService {
    void add(Movie movie);
    List<Movie> findAll();
    Movie showDetailsForOneId(Long id);
}
