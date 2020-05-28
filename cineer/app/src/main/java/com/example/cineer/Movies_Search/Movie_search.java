package com.example.cineer.Movies_Search;

import java.util.ArrayList;
//Clase Objeto que contiene la busqueda
public class Movie_search {
    private float page;
    private float total_results;
    private float total_pages;

    //ArrayList con los resultados de Movie_Results
    ArrayList <Movies_results> results = new ArrayList<Movies_results>();

    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<Movies_results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movies_results> results) {
        this.results = results;
    }
// Getter Methods

    public float getPage() {
        return page;
    }

    public float getTotal_results() {
        return total_results;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    // Setter Methods

    public void setPage(float page) {
        this.page = page;
    }

    public void setTotal_results(float total_results) {
        this.total_results = total_results;
}
}
