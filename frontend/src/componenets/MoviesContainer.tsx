import {Movie} from "../model/Movie";
import React from "react";
import MovieCard from "./MovieCard";
import AddForm from "./AddForm";


export default function MoviesContainer({movies,onFavourite,handleSubmit,onChange}:{
    movies:Movie[]
    onFavourite:(index: number) => void
    handleSubmit:  (event: React.FormEvent<HTMLFormElement>) => void
    onChange: (event: React.ChangeEvent<HTMLInputElement>)=> void
                                        }
) {



    return (<div className="d-flex flex-wrap justify-content-evenly container mb-5">
        {
            movies.map((m, index) =>
                <MovieCard key={m.id} onFavourite={() => onFavourite(index)} movie={m}/>
            )
        }
        <AddForm handleSubmit={handleSubmit} onChange={onChange}/>
    </div>)
}