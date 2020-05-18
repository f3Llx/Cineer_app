package com.example.cineer.Movies_info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cineer.R;

public class Movies_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_info);
        Intent intent_get= getIntent();
        Bundle bundle = intent_get.getExtras();
        TextView borrame = findViewById(R.id.borrame);
        if(bundle!=null)
        {
            int movie_id =(int) bundle.get("movie_id");
            borrame.setText("el id de la pelicula es: "+movie_id+"");
        }
        //peticion api donde movie_id es igual a el id de la peli
        // https://api.themoviedb.org/3/movie/{movie_id}?api_key=<<api_key>>&language=en-US


    }
}
