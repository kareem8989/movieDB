import React from 'react';
import './App.css';

import HomePage from "./pages/HomePage";
import {Route, Routes} from "react-router-dom";
import Details from "./componenets/Details";

function App() {


  return (
      <>

       <Routes>
           <Route path={"/"} element={<HomePage/>}/>
           <Route path={"/:isFavouriteActive"} element={<HomePage/>}/>
           <Route path={"/details/:id"} element={<Details/>}/>
       </Routes>

      </>


  );
}

export default App;


