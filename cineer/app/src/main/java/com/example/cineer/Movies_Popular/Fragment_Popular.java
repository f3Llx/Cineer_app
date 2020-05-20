package com.example.cineer.Movies_Popular;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cineer.Json_api_interface;
import com.example.cineer.R;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_Popular extends Fragment {
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/").addConverterFactory(GsonConverterFactory.create()).build();
    private RecyclerView mRecyclerview;
    private RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
    private Json_api_interface json_api_interface = retrofit.create(Json_api_interface.class);
    private int page;
    private TextView pageCount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        //variables initialized
        mRecyclerview = view.findViewById(R.id.popular_rv);
        ImageButton pagedown = view.findViewById(R.id.page_down);
        ImageButton pageup = view.findViewById(R.id.page_up);
        pageCount = view.findViewById(R.id.page_count);
        page = 1;
        //animation
        mRecyclerview.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.slide_up));
        ImageView info = view.findViewById(R.id.info_blink);
        info.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.blink));
        //page up click listener
        pageup.setOnClickListener(v -> {
            page++;
            getPopularMovies(page);
            pageCount.setText(page+"");
            //animation
            mRecyclerview.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));

        });
        //page down click listener
        pagedown.setOnClickListener(v -> {
            page--;
            if(page<=0){
                page=1;
            }else{
                getPopularMovies(page);
                pageCount.setText(page+"");
                //animation
                mRecyclerview.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));

            }
        });
        getPopularMovies(page);

        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {

                } else {

                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_FLING) {

                } else if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    //info.setVisibility(View.INVISIBLE);
                    info.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));

                } else {

                }
            }
        });


        return view;
    }
    private void getPopularMovies(int page) {
        String apikey = "7bce0f6bbf1e214ffa921702cabbda63";
        Call<Movies_popular> call = json_api_interface.getPopularMovies(apikey, page);
        call.enqueue(new Callback<Movies_popular>() {
            @Override
            public void onResponse(Call<Movies_popular> call, Response<Movies_popular> response) {
                Movies_popular locations = response.body();
                List<Movies_popular_results> movies_popular_results = locations.getResults();
                //debug purpose
                for (Movies_popular_results this_for_results : movies_popular_results) {
                    Log.i("info", this_for_results.getTitle());
                }
                //recycler view/adapter
                mRecyclerview.setHasFixedSize(false);
                RecyclerView.Adapter mAdapter = new Adapter_Popular((ArrayList<Movies_popular_results>) movies_popular_results);
                mRecyclerview.setLayoutManager(mLayoutManager);
                mRecyclerview.setAdapter(mAdapter);
            }
            @Override
            public void onFailure(Call<Movies_popular> call, Throwable t) {
                Log.e("error", t.toString());
            }
        });
    }
}