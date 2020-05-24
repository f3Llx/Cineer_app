package com.example.cineer.Movies_Trailer.Movies_upcoming;

import com.example.cineer.Movies_Popular.Movies_popular_results;

import java.util.List;

public class Movies_upcoming {

    List<Movies_upcoming_results> results;

    private float page;
    private float total_results;
    Dates DatesObject;
    private float total_pages;


    public List<Movies_upcoming_results> getResultsfromarray() {
        return results;
    }

    public void setResults(List<Movies_upcoming_results> results) {
        this.results = results;
    }

    public float getPage() {
        return page;
    }

    public void setPage(float page) {
        this.page = page;
    }

    public float getTotal_results() {
        return total_results;
    }

    public void setTotal_results(float total_results) {
        this.total_results = total_results;
    }

    public Dates getDatesObject() {
        return DatesObject;
    }

    public void setDatesObject(Dates datesObject) {
        DatesObject = datesObject;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }
}
class Dates {
    private String maximum;
    private String minimum;


    // Getter Methods

    public String getMaximum() {
        return maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    // Setter Methods

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }
}