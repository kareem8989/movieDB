package com.example.backend.movie;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private  MovieRepo repo;



    public List<Movie> getMovies(){
        return repo.getMovies();
    }

    public Movie getMovieByID(String id){
        return repo.getMovieByID(id);
    }

    public List<Movie>  insertMovie(Movie theMovie){
        return repo.insertMovie(theMovie);
    }

    public List<Movie> deleteMovie(String id){
        repo.deleteMovie(id);
        return repo.getMovies();
    }

    public List<Movie> updateMovie(String id ,Movie newMovie){
        repo.updateMovie(id,newMovie);
        return repo.getMovies();
    }

    public void setMovies(List<Movie> theMovies ){
         repo.setMovies(theMovies);
    }

    public void setCountMovies(int counter){
        repo.setCountMovies(counter);
    }

}
