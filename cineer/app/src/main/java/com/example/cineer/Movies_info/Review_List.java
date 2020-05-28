package com.example.cineer.Movies_info;

import java.util.ArrayList;

public class Review_List {

    private float id;
    private float page;
    ArrayList<Movies_Review> results;

    public ArrayList<Movies_Review> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movies_Review> results) {
        this.results = results;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public float getPage() {
        return page;
    }

    public void setPage(float page) {
        this.page = page;
    }
}
