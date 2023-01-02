import axios from 'axios';
import {Movie} from "../model/Movie";



export const getMovies = async (): Promise<Movie[]> => {
    const response = await axios.get<Movie[]>('/api/movies');
    return response.data;
};

export const getMovie = async (id: number): Promise<Movie> => {
    const response = await axios.get<Movie>(`/api/movies/${id}`);
    return response.data;
};

export const createMovie = async (movie: Movie): Promise<Movie> => {
    const response = await axios.post<Movie>('/api/movies', movie);
    return response.data;
};

export const updateMovie = async (movie: Movie,id: string): Promise<Movie> => {
    const response = await axios.put<Movie>('/api/movies/'+id, movie);
    return response.data;
};

export const deleteMovie = async (id: string): Promise<void> => {
    await axios.delete(`/api/movies/${id}`);
};
