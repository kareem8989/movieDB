import React, {useReducer} from 'react';
import './App.css';

import HomePage from "./pages/HomePage";
import {Route, Routes} from "react-router-dom";
import Details from "./componenets/Details";

function App() {

    // const [state, dispatch] = useReducer(
    //     (state: any, action: { type: string; payload: string; })=> {
    //         switch(action.type){
    //             case "SET_NAME":
    //                 return {...state,name: action.payload}
    //         }
    //
    //     },
    //     {
    //         names: [],
    //         name: ""
    //     });


  return (
      <>

       <Routes>
           <Route path={"/"} element={<HomePage/>}/>
           <Route path={"/:isFavouriteActive"} element={<HomePage/>}/>
           <Route path={"/details/:id"} element={<Details/>}/>
       </Routes>

        {/*<input*/}
        {/*type={"text"}*/}
        {/*value={state.name}*/}
        {/*onChange={e => dispatch({type: "SET_NAME", payload: e.target.value})}*/}
        {/*/>*/}

        {/*  <h3>Name: {state.name}</h3>*/}
      </>


  );
}

export default App;


