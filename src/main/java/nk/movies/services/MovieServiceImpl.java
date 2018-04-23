package nk.movies.services;

import nk.movies.domain.Movie;
import nk.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void add(Movie movie){
        movieRepository.save(movie);
    }

    public List<Movie> findAll(){
        return (List<Movie>)movieRepository.findAll();
    }
    public Movie showDetailsForOneId(Long id){
        Movie movie = movieRepository.findById(id).get();

        return movie;
    }

}
