package com.example.cineer.Movies_info;

import java.util.List;

public class Movies_Popular_Details {

    int budget;
    List<Genres>genres;
    String homepage;
    String original_language;
    String original_title;
    String title;
    String tagline;
    String overview;
    float popularity;
    String release_date;
    int runtime;
    String poster_path;
    Movies_Review review;
    String backdrop_path;

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Movies_Popular_Details(int budget, List<Genres> genres, String homepage, String original_language, String original_title, String title, String tagline, String overview, float popularity, String release_date, int runtime, String poster_path, Movies_Review review,String backdrop_path) {
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.original_language = original_language;
        this.original_title = original_title;
        this.title = title;
        this.tagline = tagline;
        this.overview = overview;
        this.popularity = popularity;
        this.release_date = release_date;
        this.runtime = runtime;
        this.poster_path = poster_path;
        this.review = review;
        this.backdrop_path=backdrop_path;
    }
    public Movies_Review getReview() {
        return review;
    }

    public void setReview(Movies_Review review) {
        this.review = review;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
}
