import {Movie} from "../model/Movie";
import React from "react";
import {Link} from "react-router-dom";

export default function MovieCard({movie,onFavourite}:{

       movie: Movie
       onFavourite: () => void
   }
){

return (

    <div key={movie.id} className="card" style={{width: "16rem"}}>
        <Link to={"/details/"+movie.id} onMouseOver={()=> {
            return 'SHOW DETAILS'
        }}> <img src={movie.posterURL} className="card-img-top"  alt={'MOVIE POSTER'}/>    </Link>

        <div className="card-body">
                <h5 className="card-title">{movie.title}</h5>
                <p className="card-text">
                    {movie.year}</p>
                <button type="button" className="btn btn-outline-info">Info</button>



            {
                movie.favourite? <h3><i className="fa-solid fa-heart  second-button-card"
                                        onClick={onFavourite}></i></h3>:

                  <h3><i className="fa-regular fa-heart second-button-card"
                         onClick={onFavourite}></i></h3>

            }


            </div>


    </div>


)


}

