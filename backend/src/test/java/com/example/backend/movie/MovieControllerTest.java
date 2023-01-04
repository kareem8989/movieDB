package com.example.backend.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MovieControllerTest {

    @Autowired
    MovieService service;



    @Autowired
    private MockMvc mockMvc;


    @Test
    void insert_movie_thenSuccessfullyInsertedMovie () throws Exception {
        service.setMovies(new ArrayList<>());
        service.setCountMovies(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                
                    {
                        "id": "",
                        "title": "xxx",
                        "posterURL": "zzz",
                        "year": 2022,
                        "favourite": true
                    }
                    """)
        ).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().json("""
                [
                    {
                        "id": "1",
                        "title": "xxx",
                        "posterURL": "zzz",
                        "year": 2022,
                        "favourite": true
                    }
                ]
                """,
                        true
                )
        );
    }

    @Test
    void update_whenMovieExists_thenSuccessfullyUpdateMovie() throws Exception {
        service.setMovies(new ArrayList<>());
        service.setCountMovies(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                {
                        "id": "1",
                        "title": "Movie",
                        "posterURL": "zzz",
                        "year": 2022,
                        "favourite": false
                    }
                """)
        );

        mockMvc.perform(MockMvcRequestBuilders.put("/api/movies/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "id": "1",
                        "title": "Movie updated",
                        "posterURL": "xxxx",
                        "year": 123,
                        "favourite": false
                    }
                """)
        ).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().json("""
                    [
                    {
                        "id": "1",
                        "title": "Movie updated",
                        "posterURL": "xxxx",
                        "year": 123,
                        "favourite": false
                    }
                ]
                """,
                        true
                )
        );


    }


    @Test
    void update_whenMovieDoesntExist_returnOldMoviesList () throws Exception {
        service.setMovies(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.put("/api/movies/77")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                {
                       
                        "title": "xxx",
                        "posterURL": "url",
                        "year": 2022
                }
            """)
        ).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().json("""
                []
            """,
                        true
                )
        );
    }

    @Test
    void getAll_whenMovies_thenReturnTowMovies() throws Exception {

        service.setMovies(new ArrayList<>());
        service.setCountMovies(1);

        for (int i = 0; i < 2; i++) {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/movies")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""
                {
                        "title": "Movie",
                        "posterURL": "zzz",
                        "year": 2022,
                        "favourite": false
                    }
                """)
            );
        }


        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies"))
                .andExpectAll(
                        MockMvcResultMatchers.content().json("""
                     [
                   {
                        "id": "1",
                        "title": "Movie",
                        "posterURL": "zzz",
                        "year": 2022,
                        "favourite": false
                    },
                    {
                        "id": "2",
                        "title": "Movie",
                        "posterURL": "zzz",
                        "year": 2022,
                        "favourite": false
                    }
                ]
                """)
                );
    }


    @Test
    void deleteById_whenMovieDoesntExist_then404 () throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/todos/33")
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    void deleteById() throws Exception {
        service.setMovies(new ArrayList<>());
        service.setCountMovies(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                {
                        "title": "Movie",
                        "posterURL": "zzz",
                        "year": 2022,
                        "favourite": false
                    }
                """)
        );

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/movies/1")
        ).andExpect(MockMvcResultMatchers.status().isOk()).andExpectAll( MockMvcResultMatchers.content().json("""
                      []
                """));

}

}