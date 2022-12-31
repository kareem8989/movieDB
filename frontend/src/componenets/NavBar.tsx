export default function NavBar(){


    return(
        <nav className="navbar navbar-expand-lg bg-dark-subtle sticky-sm-top">
            <div className="container">
                <a className="navbar-brand" href="#" ><h1>MovieDB</h1></a>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <a className="nav-link active" aria-current="page" href="#">todo:Home</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">todo:ink</a>
                        </li>

                    </ul>
                    <form className="d-flex" role="search">
                        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                            <button className="btn btn-outline-success" type="submit">todo:Search</button>
                    </form>
                </div>
            </div>
        </nav>

    )
}