package com.example.cineer;
import com.example.cineer.Movies_Popular.Movies_popular;
import com.example.cineer.Movies_info.Movies_Popular_Details;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Json_api_interface {

    //Todo Aqui van las llamadas de la api

    //peticion peliculas populares
    @GET("popular")
    Call<Movies_popular> getPopularMovies(@Query("api_key") String key,@Query("page") int page);

    //peticion para detalles de pelicula
    @GET("movie")
    Call<Movies_Popular_Details> getmovieDetails(@Query("api_key") String key);


}
