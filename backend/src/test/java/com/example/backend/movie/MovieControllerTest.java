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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MovieControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void insert_movie_thenSuccessfullyInsertedMovie () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                
                    {
                        "id": "14",
                        "title": "xxx",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 2022
                    }
                    """)
        ).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().json("""
                [
                    {
                        "id": "1",
                        "title": "Johnny-Depp",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 2022
                    },
                    {
                        "id": "2",
                        "title": "Home-Alone",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",
                        "year": 111
                    },
                    {
                        "id": "3",
                        "title": "New-York",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-2-Lost-in-New-York-1992-movie-posters-43713592-510-755.jpg",
                        "year": 2022
                    },
                    {
                        "id": "0",
                        "title": "xxx",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 2022
                    }
                ]
                """,
                        true
                )
        );
    }

    @Test
    void update_whenMovieExists_thenSuccessfullyUpdateMovie() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/movies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                {
                        "id": "0",
                        "title": "Movie",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 2022
                    }
                """)
        );

        mockMvc.perform(MockMvcRequestBuilders.put("/api/movies/0")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "title": "Movie updated",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 123
                    }
                """)
        ).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().json("""
                    [
                    {
                        "id": "1",
                        "title": "Johnny-Depp",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 2022
                    },
                    {
                        "id": "2",
                        "title": "Home-Alone",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",
                        "year": 111
                    },
                    {
                        "id": "3",
                        "title": "New-York",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-2-Lost-in-New-York-1992-movie-posters-43713592-510-755.jpg",
                        "year": 2022
                    },
                    {
                        "id": "0",
                        "title": "Movie updated",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 123
                    }
                ]
                """,
                        true
                )
        );


    }


    @Test
    void update_whenMovieDoesntExist_returnOldMoviesList () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/movies/77")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                {
                       
                        "title": "xxx",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 2022
                }
            """)
        ).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.content().json("""
                [
                    {
                        "id": "1",
                        "title": "Johnny-Depp",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 2022
                    },
                    {
                        "id": "2",
                        "title": "Home-Alone",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",
                        "year": 111
                    },
                    {
                        "id": "3",
                        "title": "New-York",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-2-Lost-in-New-York-1992-movie-posters-43713592-510-755.jpg",
                        "year": 2022
                    }
                ]
            """,
                        true
                )
        );
    }



    @Test
    void getAll_whenMovies_thenReturnThreeMovies() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/movies"))
                .andExpectAll(
                        MockMvcResultMatchers.content().json("""
                     [
                    {
                        "id": "1",
                        "title": "Johnny-Depp",
                        "posterURL": "https://images5.fanpop.com/image/photos/24700000/Johnny-Depp-movie-posters-movie-posters-24790093-800-1185.jpg",
                        "year": 2022
                    },
                    {
                        "id": "2",
                        "title": "Home-Alone",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",
                        "year": 111
                    },
                    {
                        "id": "3",
                        "title": "New-York",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-2-Lost-in-New-York-1992-movie-posters-43713592-510-755.jpg",
                        "year": 2022
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

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/movies/1")
        ).andExpect(MockMvcResultMatchers.status().isOk()).andExpectAll( MockMvcResultMatchers.content().json("""
                      [
                    {
                        "id": "2",
                        "title": "Home-Alone",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-3-1997-movie-posters-43713609-507-755.jpg",
                        "year": 111
                    },
                    {
                        "id": "3",
                        "title": "New-York",
                        "posterURL": "https://images6.fanpop.com/image/photos/43700000/Home-Alone-2-Lost-in-New-York-1992-movie-posters-43713592-510-755.jpg",
                        "year": 2022
                    }
                ]
                """));

}

}