import React, {useState} from "react";
import MoviesContainer from "../componenets/MoviesContainer";
import {Movie} from "../model/Movie";
import {createMovie, updateMovie} from "../api/Api";
import NavBar from "../componenets/NavBar";
import AddForm from "../componenets/AddForm";
import useMovies from "../hocks/useMovies";
import {useParams} from "react-router-dom";

export default function HomePage() {
    let {isFavouriteActive} = useParams()
    console.log(isFavouriteActive)

    const [searchTerm, setSearchTerm] = useState("");
    const [movies, setMovies] = useMovies([])
    let filteredMovies: Movie[] = movies.filter((m) => m.title.toLowerCase().includes(searchTerm.toLowerCase()));

    const [postMovie, setPostMovie] = useState(new Movie("", "", "", 0, false));

    if (isFavouriteActive === "active") {
        filteredMovies = filteredMovies.filter((m) => m.favourite)
    }

    function onFavourite(index: number): void {
       if(isFavouriteActive == undefined) {
            let theMovie = movies.at(index)
            if (theMovie) {
                theMovie.favourite = !theMovie.favourite
                updateMovie(theMovie, theMovie.id)
            }
            setMovies([...movies])
        }

        if(isFavouriteActive === "active") {
            let theMovie = filteredMovies.at(index)
            if (theMovie) {
                theMovie.favourite = false
                updateMovie(theMovie, theMovie.id)
            }
            setMovies([...movies])
        }

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
            if (postMovie.title !== "" && postMovie.posterURL !== "" && postMovie.year !== 0) {
                postMovie.id = movies.length + 1 + "";
                createMovie(postMovie)
                setMovies([...movies, postMovie])
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




    return (
        <div>
            <NavBar onSearch={(e) => setSearchTerm(e.target.value)}/>
            {filteredMovies.length > 0 ?

                <MoviesContainer movies={filteredMovies} onFavourite={onFavourite}/>
                :
                <h1 className={"no-data"}> {isFavouriteActive? "NO FAVOURITE MOVIES": "NO DATA EXIST "} </h1>}

            <AddForm handleSubmit={handleSubmit} onChange={onChange}/>
        </div>)
}