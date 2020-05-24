package com.example.cineer.Movies_Trailer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cineer.Json_api_interface;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Adapter_upcoming;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Movies_upcoming;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Movies_upcoming_results;
import com.example.cineer.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Trailer extends Fragment{
    View view;
    RecyclerView upcoming_rv;
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/").addConverterFactory(GsonConverterFactory.create()).build();
    private RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
    private Json_api_interface json_api_interface = retrofit.create(Json_api_interface.class);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_trailers, container, false);
        String youtubevideoid="TcMBFSGVi1c";

        upcoming_rv=view.findViewById(R.id.recycler_view_upcoming);


        getUpcomingMovies(1);

        return view;


    }


    private void getUpcomingMovies(int page) {
        String apikey = "7bce0f6bbf1e214ffa921702cabbda63";
        Call<Movies_upcoming> call = json_api_interface.getUpcomingmovies(apikey, page);
        call.enqueue(new Callback<Movies_upcoming>() {
            @Override
            public void onResponse(Call<Movies_upcoming> call, Response<Movies_upcoming> response) {
                Movies_upcoming locations = response.body();
                List<Movies_upcoming_results> movies_popular_results = locations.getResultsfromarray();
                for (Movies_upcoming_results this_for_results : movies_popular_results) {
                               Log.e("info", this_for_results.getTitle());
                           }
                upcoming_rv.setHasFixedSize(false);
               RecyclerView.Adapter mAdapter = new Adapter_upcoming((ArrayList<Movies_upcoming_results>) movies_popular_results);


                upcoming_rv.setLayoutManager(mLayoutManager);
                upcoming_rv.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<Movies_upcoming> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });



        //call.enqueue(new Callback<Movies_popular>() {
        //    @Override
        //    public void onResponse(Call<Movies_popular> call, Response<Movies_popular> response) {
        //        Movies_popular locations = response.body();
        //        List<Movies_popular_results> movies_popular_results = locations.getResults();
        //        //debug purpose
        //        for (Movies_popular_results this_for_results : movies_popular_results) {
        //            Log.i("info", this_for_results.getTitle());
        //        }
        //        //recycler view/adapter
        //        mRecyclerview.setHasFixedSize(false);
        //        RecyclerView.Adapter mAdapter = new Adapter_Popular((ArrayList<Movies_popular_results>) movies_popular_results);
        //        mRecyclerview.setLayoutManager(mLayoutManager);
        //        mRecyclerview.setAdapter(mAdapter);
        //    }
        //    @Override
        //    public void onFailure(Call<Movies_popular> call, Throwable t) {
        //        Log.e("error", t.toString());
        //    }
        //});
    }



}