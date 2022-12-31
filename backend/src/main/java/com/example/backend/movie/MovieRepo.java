package com.example.backend.movie;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Data
@Repository
public class MovieRepo{



    List<Movie> movies = new ArrayList<>(List.of(
            new Movie("1","Johnny-Depp","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",2022,false),
            new Movie("2"," Race to Witch Mountain","http://www.freemovieposters.net/posters/race_to_witch_mountain_2009_2392_poster.jpg",2009,false),
            new Movie("3","TITANIC","http://www.freemovieposters.net/posters/titanic_1997_6121_poster.jpg",1997,false),
            new Movie("4","SCARFACE","http://www.freemovieposters.net/posters/scarface_1983_6126_poster.jpg",1983,false),
            new Movie("5","underworld".toUpperCase(),"http://www.freemovieposters.net/posters/underworld_evolution_2006_1529_poster.jpg",2006,true)


    ));
//    List<Movie> movies = new ArrayList<>();

    private static final  int LIMIT_MOVIES = 10;
    private int countMovies = movies.size() + 5;


    public List<Movie> getMovies(){
        return movies;
    }

    public Movie getMovieByID(String id){

        for (Movie Movie : movies) {
            if (Movie.getId().equals(id)) { return Movie;}
        }
        return null;
    }

    public List<Movie>  insertMovie(Movie theMovie){

        String id = "" + countMovies;

        if(countMovies != LIMIT_MOVIES){
            theMovie.setId(id);
            movies.add(theMovie);
            countMovies++;
        }

        return movies;
    }

    public List<Movie> deleteMovie(String id){

        if(getMovieByID(id) != null){
            movies.remove(getMovieByID(id));
            return movies;
        }
        throw new NoSuchElementException("Movie Not Found");
    }

    public List<Movie> updateMovie(String id ,Movie newMovie){

        if(getMovieByID(id) != null){
            Movie theMovie = getMovieByID(id);
            newMovie.setId(id);
            int idx = movies.indexOf(theMovie);

            movies.set(idx,newMovie);
        }
        return movies;
    }


    public List<Movie> setMovies(List<Movie> theMovies){
        return this.movies = theMovies;
    }


}
