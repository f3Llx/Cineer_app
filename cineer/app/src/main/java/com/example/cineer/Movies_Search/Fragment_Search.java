package com.example.cineer.Movies_Search;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cineer.Json_api_interface;
import com.example.cineer.Movies_Popular.Adapter_Popular;
import com.example.cineer.Movies_Popular.Movies_popular_results;
import com.example.cineer.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Search extends Fragment {
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create()).build();
    private Json_api_interface json_api_interface = retrofit.create(Json_api_interface.class);
    RecyclerView recicler;
    SearchView search;
    View view;
    TextView results;
    View results_line;
    ProgressBar searchProgressbar;
 Boolean isSearching;
    private RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_bar, container, false);
        search = view.findViewById(R.id.searchView3);
        recicler = view.findViewById(R.id.rv_comms);
        results=view.findViewById(R.id.results_num);
        results_line=view.findViewById(R.id.results_line);
        results.setVisibility(View.GONE);
        results_line.setVisibility(View.GONE);
        searchProgressbar=view.findViewById(R.id.progressBar_search);
 isSearching=false;
        //Actualizar la barra de busqueda
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //todo aqui va la busqueda
                if (!s.equals("")) {
                    recicler.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.blink_once));
                    recicler.setVisibility(View.VISIBLE);
                    onsearch(s);
                    if(!isSearching){
                        searchProgressbar.setVisibility(View.VISIBLE);
                        isSearching=true;
                    }

                }else{
                    recicler.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_dissapear));
                    Handler handler = new Handler();
                    handler.postDelayed(() -> recicler.setVisibility(View.GONE), 500);
                    results.setVisibility(View.GONE);
                    results_line.setVisibility(View.GONE);
                    searchProgressbar.setVisibility(View.GONE);
                    isSearching=false;

                }
                return false;
            }
        });

        return view;
    }

    private void onsearch(String query) {
        String apikey = "7bce0f6bbf1e214ffa921702cabbda63";
        Call<Movie_search> call = json_api_interface.getsearch(query, apikey);
        call.enqueue(new Callback<Movie_search>() {
            @Override
            public void onResponse(Call<Movie_search> call, Response<Movie_search> response) {
                Movie_search busqueda = response.body();
                List<Movies_results> movies = busqueda.getResults();


                if (!movies.isEmpty()) {
                    recicler.setHasFixedSize(false);
                    RecyclerView.Adapter mAdapter = new SearchAdapter((ArrayList<Movies_results>) movies);
                    recicler.setLayoutManager(mLayoutManager);
                    recicler.setAdapter(mAdapter);
                    results.setVisibility(View.VISIBLE);
                    results_line.setVisibility(View.VISIBLE);
                    if (movies.size()>=5){
                        results.setText("Results: "+5);
                    }else{
                        results.setText("Results: "+movies.size());
                    }


                }
                //recycler view/adapter

            }

            @Override
            public void onFailure(Call<Movie_search> call, Throwable t) {
                Log.d("RETROFIT", "Error: " + t.getMessage());
            }
        });


    }

}

