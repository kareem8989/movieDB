import React, { useState} from "react";
import MoviesContainer from "../componenets/MoviesContainer";
import {Movie} from "../model/Movie";
import { updateMovie} from "../api/Api";
import NavBar from "../componenets/NavBar";
import AddForm from "../componenets/AddForm";
import useMovies from "../hocks/useMovies";
import {useParams} from "react-router-dom";

export default function HomePage() {
    let {isFavouriteActive} = useParams()


    console.log(isFavouriteActive)


    const [movies, setMovies] = useMovies([])
    const [searchTerm, setSearchTerm] = useState("");
    const [postMovie, setPostMovie] = useState(new Movie("", "", "", 0, false));



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
                postMovie.id = movies.length + 1 +"";
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



    let filteredMovies: Movie[] = movies.filter((m) => m.title.toLowerCase().includes(searchTerm.toLowerCase()));



    if (isFavouriteActive === "active"){
        filteredMovies = movies.filter((m) => m.favourite)

    }




    return (
        <div>
             <NavBar onSearch={(e)=> setSearchTerm(e.target.value)}/>

            {filteredMovies.length > 0  ?

                <MoviesContainer movies={filteredMovies}  onFavourite={onFavourite}/>
                :
            <h1 className={"no-data"}>No Data</h1>}



            <AddForm handleSubmit={handleSubmit} onChange={onChange}/>
        </div>)
}