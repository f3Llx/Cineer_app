package com.example.cineer.Movies_Trailer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cineer.Json_api_interface;
import com.example.cineer.Movies_Popular.Adapter_Popular;
import com.example.cineer.Movies_Popular.Movies_popular;
import com.example.cineer.Movies_Popular.Movies_popular_results;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Movies_upcoming_detail;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Videos;
import com.example.cineer.Movies_Trailer.Movies_upcoming.Videos_result;
import com.example.cineer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_showTrailer extends Fragment {
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frament_trailers_showtrailer, container, false);

        String videoid = getArguments().getString("id");

        loadTrailer(view, videoid);


        return view;
    }


    private void loadTrailer(View view, String videoId) {
        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }





    }

