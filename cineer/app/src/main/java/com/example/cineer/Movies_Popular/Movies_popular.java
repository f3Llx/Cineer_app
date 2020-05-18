package com.example.cineer.Movies_Popular;
import java.util.List;

public class Movies_popular {
    private float page;
    private float total_results;
    private float total_pages;
    List<Movies_popular_results> getResults() {
        return results;
    }
    public void setResults(List<Movies_popular_results> results) {
        this.results = results;
    }
    List<Movies_popular_results> results;
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
    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }
}