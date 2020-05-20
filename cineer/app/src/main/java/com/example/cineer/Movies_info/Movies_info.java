package com.example.cineer.Movies_info;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cineer.Json_api_interface;
import com.example.cineer.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Movies_info extends AppCompatActivity {

    private RecyclerView rv_Detalle;
    private ImageView iv;
    private TextView tv_title, tv_subtitle, budget, homepage, original_languaje, original_title, overview, release_date, runtime;
    private Movies_Popular_Details moviesPopularDetails;
    int movie_id;


    private Retrofit retrofit;
    private RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    //private Json_api_interface json_api_interface = retrofit.create(Json_api_interface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_info);
        Intent intent_get= getIntent();
        Bundle bundle = intent_get.getExtras();
        if(bundle!=null)
        {
            movie_id =(int) bundle.get("movie_id");
        }

        lanzarPeticion();

    }

    private void setUpView(){
        iv = findViewById(R.id.imageView);
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

    private void lanzarPeticion (){
        String apikey = "20da572d6d158a453c70756fd8f11ed0";
        retrofit =  new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(GsonConverterFactory.create()).build();
        Json_api_interface jsonApiInterface = retrofit.create(Json_api_interface.class);

        Call<Movies_Popular_Details> call = jsonApiInterface.getmovieDetails(454626,apikey);
        call.enqueue(new Callback<Movies_Popular_Details>() {
            @Override
            public void onResponse(Call<Movies_Popular_Details> call, Response<Movies_Popular_Details> response) {
                Movies_Popular_Details moviesPopularDetails = response.body();
                setUpView();
                //para recuperar la info la sacas usando moviesPopularDetails.get etc.... :)
                budget.setText(moviesPopularDetails.getBudget()+"");


            }

            @Override
            public void onFailure(Call<Movies_Popular_Details> call, Throwable t) {
                Log.e("RETROFIT", "Error " + t.getMessage());
                Toast.makeText(Movies_info.this, "fallo"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
