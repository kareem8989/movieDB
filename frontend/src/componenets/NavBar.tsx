import React, {useState} from "react";
import {Link} from "react-router-dom";

export default function NavBar({onSearch}: {
    onSearch: (event: React.ChangeEvent<HTMLInputElement>) => void
}) {

    const [isFavourite,setIsFavourite] = useState(false)
    const [path,setPath] = useState("active")


    let activeLikClass = ""
    const switchFavourite = (): void => {
        setIsFavourite(!isFavourite)
        if(isFavourite){
           setPath("active")
            activeLikClass = ""
        }else if (!isFavourite){
            setPath("")
            activeLikClass = "activeLinkClass"


        }

        console.log(activeLikClass)


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
                                <Link className={"nav-link " +{activeLikClass}} aria-current="page" onClick={switchFavourite} to={`/${path}`}>Favourite</Link>
                            </li>


                        </ul>
                        <div className="d-flex" role="search"><input className="form-control me-2" type={"text"} onChange={onSearch}
                                   placeholder="search by title"/>
                        </div>

                    </div>
                </div>
            </nav>

        </>

    )
}