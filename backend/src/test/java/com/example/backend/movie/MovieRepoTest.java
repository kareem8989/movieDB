package com.example.backend.movie;


import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepoTest {

    MovieRepo rep = new MovieRepo();

    @Test
    void getMovies_getAllMovies() {
        rep.setMovies(new ArrayList<>());
        // given
        List<Movie> expected = new ArrayList<>(List.of());
        // when
        List<Movie> actual = rep.getMovies();
        // then
        assertEquals(expected, actual);

    }


    @Test
    void getMovies_emptyMoviesAray() {
        // given
        List<Movie> expected = rep.setMovies(new ArrayList<>());

        // when
        List<Movie> actual = rep.getMovies();
        // then
        assertEquals(expected, actual);

    }

    @Test
    void getMovieByID_getOneMovie() {
        rep.setMovies(new ArrayList<>(List.of(
                new Movie("1", "Name", "url", 2022, false),
                new Movie("2", "Name", "url", 2022, false)
        )));
        // GIVEN
        String id = "1";
        Movie axpected = new Movie("1", "Name", "url", 2022, false);

        // WHEN
        Movie actual = rep.getMovieByID(id);

        // THEN

        assertEquals(axpected, actual);
    }

    @Test
    void getMovieByID_movieNotFound_return_null() {
        // GIVEN
        String id = "44";

        // WHEN
        Movie actual = rep.getMovieByID(id);
        // THEN

        assertNull(actual);
    }

    @Test
    void insertMovie() {
        rep.setCountMovies(3);
        rep.setMovies(new ArrayList<>(List.of(
                new Movie("1", "Name", "url", 2022, false),
                new Movie("2", "Name", "url", 2022, false)
        )));
        // Given
        Movie addedMovie = new Movie("3", "xxx", "xxx", 777, false);

        List<Movie> expected = new ArrayList<>(List.of(
                new Movie("1", "Name", "url", 2022, false),
                new Movie("2", "Name", "url", 2022, false),
                new Movie("3", "xxx", "xxx", 777, false)
        ));

        // When
        List<Movie> actual = rep.insertMovie(addedMovie);

        // Then
        assertEquals(expected, actual);

    }


    @Test
    void deleteMovie() {
        rep.setMovies(new ArrayList<>(List.of(
                new Movie("1", "Name", "url", 2022, false),
                new Movie("2", "Name", "url", 2022, false)
        )));
        // Given
        String id = "2";

        List<Movie> expected = new ArrayList<>(List.of(
                new Movie("1", "Name", "url", 2022, false)
        ));

        // When
        List<Movie> actual = rep.deleteMovie(id);

        // Then
        assertEquals(expected, actual);

    }

    @Test
    void updateMovie() {
        rep.setCountMovies(1);
        rep.setMovies(new ArrayList<>(List.of(
                new Movie("1", "Name", "url", 2022, false)
        )));
        // Given

        Movie theUpdated = new Movie("1", "xx", "xxx", 2022, false);


        List<Movie> expected = new ArrayList<>(List.of(
                new Movie("1", "xx", "xxx", 2022, false)
        ));


        // When

        List<Movie> actual = rep.updateMovie(theUpdated.getId(), theUpdated);

        // Then
        assertEquals(expected, actual);
    }
}