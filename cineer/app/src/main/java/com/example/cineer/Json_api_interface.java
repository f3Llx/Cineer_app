package com.example.cineer;
import com.example.cineer.Movies_Popular.Movies_popular;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Movies_upcoming;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Movies_upcoming_detail;
import com.example.cineer.Movies_info.Movies_Popular_Details;
import com.example.cineer.Movies_info.Movies_Review;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Json_api_interface {

    //Todo Aqui van las llamadas de la api

    //peticion peliculas populares
    @GET("popular")
    Call<Movies_popular> getPopularMovies(@Query("api_key") String key,@Query("page") int page);

    //peticion para detalles de pelicula
    @GET("movie/{movie_id}")
    Call<Movies_Popular_Details> getmovieDetails(@Path("movie_id") int id, @Query("api_key") String key);

    //peticion review de peliculas
    @GET("movie/{movie_id}/reviews")
    Call<Movies_Review> getReviews(@Path("movie_id") int id, @Query("api_key") String key);


    //peticion peliculas upcoming
    @GET("upcoming")
    Call<Movies_upcoming> getUpcomingmovies(@Query("api_key") String key, @Query("page") int page);

    //peticion peliculas trailers
    @GET("movie/{movie_id}")
    Call<Movies_upcoming_detail> getUpcomingMovieDetails(@Path("movie_id") int id, @Query("api_key") String key,@Query("append_to_response") String videos);

}
