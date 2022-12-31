import {Movie} from "../model/Movie";
import {Dispatch, SetStateAction, useEffect, useState} from "react";
import {getMovies} from "../api/Api";

export default function useMovies(initialState: Movie[]): [Movie[], Dispatch<SetStateAction<Movie[]>>] {
    const [movies, setMovies] = useState<Movie[]>([]);

    useEffect(() => {
        (async () => {
            const movies = await getMovies();
            setMovies(movies);
        })();
    }, []);

    return [movies, setMovies]
}