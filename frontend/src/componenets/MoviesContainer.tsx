import {Movie} from "../model/Movie";
import React from "react";
import MovieCard from "./MovieCard";


export default function MoviesContainer({movies,onFavourite}:{
    movies:Movie[]
    onFavourite:(index: number) => void

                                        }
) {



    return (<div className="d-flex align-content-start flex-wrap container mb-5 test ">
        {
            movies.map((m, index) =>
                <MovieCard key={m.id} onFavourite={() => onFavourite(index)} movie={m}/>
            )
        }
    </div>)
}