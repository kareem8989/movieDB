import React, {useEffect, useState} from "react";
import MoviesContainer from "../componenets/MoviesContainer";
import {Movie} from "../model/Movie";
import {createMovie, getMovies, updateMovie} from "../api/Api";
import NavBar from "../componenets/NavBar";

export default function HomePage() {
    const [movies, setMovies] = useState<Movie[]>([])
    const [searchTerm, setSearchTerm] = useState("");
    const [postMovie, setPostMovie] = useState(new Movie("", "", "", 0, false));


    useEffect(() => {
        const fetchMovies = async () => {
            const response = await getMovies()
            setMovies(response)
        };
        fetchMovies();

    }, []);


    function onFavourite(index: number): void {
        let theMovie = movies.at(index)
        if (theMovie) {
            theMovie.favourite = !theMovie.favourite
            updateMovie(theMovie, theMovie.id)
        }
        setMovies([...movies])
        //      setMovies(movies.map(m => {
        //
        //          if(theMovie && m.id === theMovie.id){
        //              theMovie.favourite = !theMovie.favourite
        //              return  theMovie
        //          }
        //          return m;
        //      }))
    }


    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault()
        try {
            if (postMovie.title != "" && postMovie.posterURL != "" && postMovie.year != 0) {
                setMovies([...movies, postMovie])
                createMovie(postMovie)
            }
        } catch (error) {
            console.error(error);
        }

    };

    const onChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = event.target
        setPostMovie(
            {...postMovie, [name]: value} as Movie)
    }



    let filteredMovies = movies.filter((m) => m.title.toLowerCase().includes(searchTerm.toLowerCase()))




    return (
        <div>
             <NavBar onSearch={(e)=> setSearchTerm(e.target.value)}/>
             <MoviesContainer movies={filteredMovies} onChange={onChange} onFavourite={onFavourite} handleSubmit={handleSubmit}/>
        </div>)
}