package com.example.backend.movie;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService service;

    @GetMapping
    public List<Movie> getAllMovies(){
        return service.getMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable String id){
        return service.getMovieByID(id);
    }

    @PostMapping
    public List<Movie> insertMoveie(@RequestBody Movie theMove){
        return service.insertMovie(theMove);
    }

    @PutMapping("/{id}")
    public List<Movie> updateMovie(@PathVariable String id, @RequestBody Movie theMovie){

        return service.updateMovie(id,theMovie);
    }

    @DeleteMapping("/{id}")
    public List<Movie> deleteMovie(@PathVariable String id){
        return service.deleteMovie(id);
    }
}
