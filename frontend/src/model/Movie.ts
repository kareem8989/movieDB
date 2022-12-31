import React from "react";

export class Movie {
    private _id: string;
    private _title: string;
    private _posterURL: string;
    private _year: number;
    private _favourite: boolean;


    constructor(id: string, title: string, posterURL: string, year: number, favourite: boolean) {
        this._id = id;
        this._title = title;
        this._posterURL = posterURL;
        this._year = year;
        this._favourite = favourite;
    }

    get id(): string {
        return this._id;
    }

    set id(value: string) {
        this._id = value;
    }

    get title(): string {
        return this._title;
    }

    set title(value: string) {
        this._title = value;
    }

    get posterURL(): string {
        return this._posterURL;
    }

    set posterURL(value: string) {
        this._posterURL = value;
    }

    get year(): number {
        return this._year;
    }

    set year(value: number) {
        this._year = value;
    }

    get favourite(): boolean {
        return this._favourite;
    }

    set favourite(value: boolean) {
        this._favourite = value;
    }

}