package com.example.cineer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cineer.Movies_Popular.Fragment_Popular;
import com.example.cineer.Movies_Search.Fragment_Search;
import com.example.cineer.Movies_Trailer.Fragment_Trailer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instanciado de los fragments
        Fragment_Search fragment_search=new Fragment_Search();
        Fragment_Popular fragment_popular=new Fragment_Popular();
        Fragment_Trailer fragment_trailer=new Fragment_Trailer();

        FragmentManager manager=getSupportFragmentManager();

        FragmentTransaction transaction=manager.beginTransaction();
        //se añaden los fragments
        transaction.add(R.id.My_Container_1_ID, fragment_search, "Frag_Top_tag");
        transaction.add(R.id.My_Container_2_ID, fragment_popular, "Frag_Middle_tag");
        transaction.add(R.id.My_Container_3_ID, fragment_trailer, "Frag_Bottom_tag");

        transaction.commit();


    }
}
