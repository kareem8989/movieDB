import React from "react";
import useMovies from "../hocks/useMovies";
import { useParams} from "react-router-dom";

export default function Details() {

    const {id} = useParams<string>()

    const [movies] = useMovies([])

    const movie = movies.find(m => m.id === id);

    if(movie == undefined){
        return <h1>no Movie found</h1>
    }



    return (
        <>
            <nav className="navbar navbar-expand-lg bg-dark-subtle sticky-sm-top">
                <div className="container">
                    <a className="navbar-brand" href="#"><h1>MovieDB</h1></a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="/">Back</a>
                            </li>


                        </ul>

                    </div>
                </div>
            </nav>



        <div className={"container d-flex justify-content-center"}>

            <div key={movie.id} className="card card-container-details" style={{width: "20rem"}}>
                <img src={movie.posterURL} className="card-img-top" alt="..."/>

                <div className="card-body">
                    <h5 className="card-title text-center">{movie.title}</h5>
                    <p className="card-text text-center">
                        {movie.year}</p>

                </div>
                <div className="d-grid  ">

                </div>


            </div>


        </div>
        </>

    )
}