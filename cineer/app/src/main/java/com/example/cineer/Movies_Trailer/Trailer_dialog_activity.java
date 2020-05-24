package com.example.cineer.Movies_Trailer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cineer.Json_api_interface;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Movies_upcoming_detail;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Videos;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Videos_result;
import com.example.cineer.R;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Trailer_dialog_activity extends AppCompatActivity {
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create()).build();
    private Json_api_interface json_api_interface = retrofit.create(Json_api_interface.class);
    int movie_id;
    TextView tittle;
    ImageView poster,getPoster;
    ConstraintLayout backdrop,layout;
    TextView overview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer_dialog_activity);
        layout=findViewById(R.id.layout_upcoming_detail);
        layout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in));
        Intent intent_get= getIntent();
        Bundle bundle = intent_get.getExtras();
        if(bundle!=null)
        {
            movie_id =(int) bundle.get("movie_id_trailer");
        }
         backdrop = findViewById(R.id.backdrop);
        tittle=findViewById(R.id.upcoming_detail_tittle);
        poster=findViewById(R.id.tumbnail_poster_detail_upcoming);
        getPoster=findViewById(R.id.get_drawable);
        overview=findViewById(R.id.overview);
        getPopularMovies(movie_id);

    }



    public void refreshFragment(String query) {
        Bundle bundle = new Bundle();
        bundle.putString("id", query);
        Fragment_showTrailer fragment_search = new Fragment_showTrailer();
        FragmentManager fragmentManagermanager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManagermanager.beginTransaction();
        transaction.add(R.id.show_trailer, fragment_search, "Fragment_trailer");
        fragment_search.setArguments(bundle);
        transaction.commit();

    }
    public void killfragment() {
        FragmentManager fragmentManagermanager = getSupportFragmentManager();
        assert fragmentManagermanager != null;
        FragmentTransaction transaction = fragmentManagermanager.beginTransaction();
        transaction.remove(Objects.requireNonNull(fragmentManagermanager.findFragmentByTag("Fragment_trailer")));
        transaction.commit();
    }
    private void getPopularMovies(int movie_id) {
        String apikey = "7bce0f6bbf1e214ffa921702cabbda63";
        Call<Movies_upcoming_detail> call = json_api_interface.getUpcomingMovieDetails(movie_id, apikey, "videos");
        call.enqueue(new Callback<Movies_upcoming_detail>() {
            @Override
            public void onResponse(Call<Movies_upcoming_detail> call, Response<Movies_upcoming_detail> response) {
                Movies_upcoming_detail locations = response.body();
                tittle.setText(locations.getTitle());
                overview.setText(locations.getOverview());
                Transformation transformation = new RoundedTransformationBuilder()
                        .borderColor(Color.BLACK)
                        .borderWidthDp(0)
                        .cornerRadiusDp(720)
                        .oval(false)
                        .build();
                Picasso.get()
                        .load("https://image.tmdb.org/t/p/w500/"+locations.getPoster_path() )
                        .noPlaceholder().fit().transform(transformation)
                        .into( poster );
               // backdrop.setBackgroundDrawable(img.getDrawable());

                Picasso.get()
                        .load("https://image.tmdb.org/t/p/w500/"+locations.getBackdrop_path())
                        .fit()
                        .into(getPoster, new com.squareup.picasso.Callback() {

                            @Override
                            public void onSuccess() {
                                backdrop.setBackgroundDrawable(getPoster.getDrawable());

                            }

                            @Override
                            public void onError(Exception e) {

                            }
                        });

                Videos videos= locations.getVideos();
                if (!(videos==null)){
                    int videos_size= videos.getResults().size();
                    if(videos_size>=1){
                        Videos_result videos_result= videos.getResults().get(0);

                       if(!(getSupportFragmentManager().findFragmentByTag("Fragment_trailer")==null)){
                           killfragment();
                       }
                        //my fragment is visible

                        //other fragment is visibile

                        refreshFragment(videos_result.getKey());
                    }
                }





            }
            @Override
            public void onFailure(Call<Movies_upcoming_detail> call, Throwable t) {

            }
        });
}

}
