package com.example.cineer.Movies_info;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cineer.Json_api_interface;
import com.example.cineer.Movies_Popular.Adapter_Popular;
import com.example.cineer.Movies_Popular.Movies_popular;
import com.example.cineer.Movies_Popular.Movies_popular_results;
import com.example.cineer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Movies_info extends AppCompatActivity {

    private ImageView iv;
    private TextView tv_title, tv_subtitle, budget, homepage, original_languaje,
            original_title, overview, release_date, runtime, review;
    int movie_id;
    private Retrofit retrofit, retrofit2;
    private RecyclerView mRecyclerview;
    private RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_info);
        Intent intent_get = getIntent();
        Bundle bundle = intent_get.getExtras();
        if (bundle != null) {
            movie_id = (int) bundle.get("movie_id");
        }

        review = findViewById(R.id.tv_Review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarPeticionReview();
            }
        });

        lanzarPeticion();

    }

    private void setUpView() {
        iv = findViewById(R.id.poster_details);
        tv_title = findViewById(R.id.tv_Title);
        tv_subtitle = findViewById(R.id.tv_Tagline);
        budget = findViewById(R.id.budget);
        homepage = findViewById(R.id.homepage);
        original_languaje = findViewById(R.id.original_language);
        original_title = findViewById(R.id.original_title);
        overview = findViewById(R.id.overview);
        release_date = findViewById(R.id.release_date);
        runtime = findViewById(R.id.runtime);
    }

    private void lanzarPeticion() {
        String apikey = "20da572d6d158a453c70756fd8f11ed0";
        retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create()).build();
        Json_api_interface jsonApiInterface = retrofit.create(Json_api_interface.class);

        Call<Movies_Popular_Details> call = jsonApiInterface.getmovieDetails(movie_id, apikey);
        call.enqueue(new Callback<Movies_Popular_Details>() {
            @Override
            public void onResponse(Call<Movies_Popular_Details> call, Response<Movies_Popular_Details> response) {
                Movies_Popular_Details moviesPopularDetails = response.body();
                setUpView();
                //para recuperar la info la sacas usando moviesPopularDetails.get etc.... :)
                tv_title.setText(moviesPopularDetails.getTitle() + "");
                tv_subtitle.setText(moviesPopularDetails.getTagline() + "");
                budget.setText(moviesPopularDetails.getBudget() + "");
                homepage.setText(moviesPopularDetails.getHomepage() + "");
                original_languaje.setText(moviesPopularDetails.getOriginal_language() + "");
                original_title.setText(moviesPopularDetails.getOriginal_title() + "");
                overview.setText(moviesPopularDetails.getOverview() + "");
                release_date.setText(moviesPopularDetails.getRelease_date() + "");
                runtime.setText(moviesPopularDetails.getRuntime() + "");
                Picasso.get()
                        .load("https://image.tmdb.org/t/p/w500/" + moviesPopularDetails.getBackdrop_path())
                        .noPlaceholder().fit().centerCrop()
                        .into(iv);
            }

            @Override
            public void onFailure(Call<Movies_Popular_Details> call, Throwable t) {
                Log.e("RETROFIT", "Error " + t.getMessage());
                Toast.makeText(Movies_info.this, "fallo" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void lanzarPeticionReview() {
        String apikey = "20da572d6d158a453c70756fd8f11ed0";
        retrofit2 = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create()).build();
        Json_api_interface jsonApiInterface = retrofit.create(Json_api_interface.class);

        Call<Review_List> call = jsonApiInterface.getReviews(movie_id, apikey);
        call.enqueue(new Callback<Review_List>() {
            @Override
            public void onResponse(Call<Review_List> call, Response<Review_List> response) {
                Review_List locations = response.body();
                List<Movies_Review> movies_reviews = locations.getResults();
                mRecyclerview = findViewById(R.id.rv_detalle);

                mRecyclerview.setHasFixedSize(false);
                RecyclerView.Adapter mAdapter = new Adapter_Detalle((ArrayList<Movies_Review>) movies_reviews);
                mRecyclerview.setLayoutManager(mLayoutManager);
                mRecyclerview.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<Review_List> call, Throwable t) {
                Log.e("RETROFIT", "Error " + t.getMessage());
                Toast.makeText(Movies_info.this, "fallo" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}