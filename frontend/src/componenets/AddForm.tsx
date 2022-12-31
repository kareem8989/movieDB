import React, {ChangeEventHandler, useState} from "react";
import {Movie} from "../model/Movie";
import axios from "axios";

export default function AddForm(props: {
    handleSubmit: (event: React.FormEvent<HTMLFormElement>) => void,
    onChange :  (event: React.ChangeEvent<HTMLInputElement> ) => void

}) {





        return (
        <div className="mb-4 container">
            <form onSubmit={props.handleSubmit}>
                <div >
                    <label htmlFor="exampleFormControlInput1" className="form-label">Movie Title</label>
                    <input type="text" className="form-control" id="exampleFormControlInput1" placeholder="Movie Title"
                    name={"title"}
                    onChange={props.onChange}
                    />

                    <label htmlFor="exampleFormControlInput1 " className="form-label">The Year of production </label>
                    <input type="text" className="form-control mb-4" id="exampleFormControlInput1" placeholder="example 1980"
                       name={"year"}
                        onChange={props.onChange}
                    />
                </div>
                <div >
                    <label htmlFor="exampleFormControlTextarea1" className="form-label">Link of Movie Poster </label>
                    <input className="form-control" id="exampleFormControlTextarea1"
                    name={"posterURL"}
                              onChange={props.onChange}
                    ></input>
                </div>
                <input className={"btn btn-light mt-2"} type={"submit"} value={"Save"}/>
            </form>
        </div>
    )
}