package com.example.cineer.Movies_Trailer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.cineer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class Fragment_Trailer extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_trailers, container, false);
       loadTrailer(view,"TcMBFSGVi1c");

        return view;


    }


   private void loadTrailer (View view,String videoId){
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