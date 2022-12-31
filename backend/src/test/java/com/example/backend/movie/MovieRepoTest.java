package com.example.backend.movie;


import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepoTest {

    MovieRepo rep = new MovieRepo();
    @Test
    void getMovies_getAllMovies() {
        // given
        List<Movie> expected = new ArrayList<>(List.of(
                new Movie("1","Johnny-Depp","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",2022),
                new Movie("2","Home-Alone","https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",111),
                new Movie("3","New-York","https://images6.fanpop.com/image/photos/43700000/Home-Alone-2-Lost-in-New-York-1992-movie-posters-43713592-510-755.jpg",2022)));
        // when
        List<Movie> actual = rep.getMovies();
        // then
        assertEquals(expected, actual);

    }


    @Test
    void getMovies_emptyMoviesAray() {
        // given
        List<Movie> expected = rep.setMovies(new ArrayList<Movie>());

        // when
        List<Movie> actual = rep.getMovies();
        // then
        assertEquals(expected, actual);

    }

    @Test
    void getMovieByID_getOneMovie() {
        // GIVEN
        String id = "1";
        Movie axpected =  new Movie("1","Johnny-Depp","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",2022);

        // WHEN
        Movie actual = rep.getMovieByID(id);
        // THEN

        assertEquals(axpected,actual);
    }

    @Test
    void getMovieByID_movieNotFound_return_null() {
        // GIVEN
        String id = "44";

        // WHEN
        Movie actual = rep.getMovieByID(id);
        // THEN

        assertEquals(null,actual);
    }

    @Test
    void insertMovie() {
        // Given
        Movie addedMovie =  new Movie("8","xxx","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",777);

        List<Movie> expected = new ArrayList<>(List.of(
                new Movie("1","Johnny-Depp","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",2022),
                new Movie("2","Home-Alone","https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",111),
                new Movie("3","New-York","https://images6.fanpop.com/image/photos/43700000/Home-Alone-2-Lost-in-New-York-1992-movie-posters-43713592-510-755.jpg",2022),
                new Movie("0","xxx","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",777)));

        // When
         List<Movie> actual = rep.insertMovie(addedMovie);

         // Then
        assertEquals(expected,actual);

    }


    @Test
    void deleteMovie() {
        // Given
        String id = "3";

        List<Movie> expected = new ArrayList<>(List.of(
                new Movie("1","Johnny-Depp","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",2022),
                new Movie("2","Home-Alone","https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",111)
                ));

        // When
        List<Movie> actual = rep.deleteMovie(id);

        // Then
        assertEquals(expected,actual);

    }

    @Test
    void updateMovie() {
        // Given
        Movie theUpdated =new Movie("1","xx","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",2022);

                List<Movie> expected = new ArrayList<>(List.of(
                        new Movie("1","xx","https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",2022),
                        new Movie("2","Home-Alone","https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",111),
                        new Movie("3","New-York","https://images6.fanpop.com/image/photos/43700000/Home-Alone-2-Lost-in-New-York-1992-movie-posters-43713592-510-755.jpg",2022)));


        // When

        List<Movie> actual = rep.updateMovie(theUpdated.getId(), theUpdated);

        // Then
        assertEquals(expected,actual);
    }
}