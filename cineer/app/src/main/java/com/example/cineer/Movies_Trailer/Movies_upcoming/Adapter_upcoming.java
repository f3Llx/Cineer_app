package com.example.cineer.Movies_Trailer.Movies_upcoming;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cineer.Movies_Trailer.Trailer_dialog_activity;
import com.example.cineer.R;
import com.squareup.picasso.Picasso;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
public class Adapter_upcoming extends RecyclerView.Adapter<Adapter_upcoming.ExampleViewHolder> {
    private ArrayList<Movies_upcoming_results> mExampleList;
    static class ExampleViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView movie_tittle;
        ExampleViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.movie_popular_poster);
            movie_tittle = itemView.findViewById(R.id.movie_popular_tittle);
        }
    }
    public Adapter_upcoming(ArrayList<Movies_upcoming_results> exampleList) {
        mExampleList = exampleList;
    }
    @NotNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_trailer_upcoming_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Movies_upcoming_results currentItem = mExampleList.get(position);
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+currentItem.getPoster_path() )
                .noPlaceholder()
                .into( holder.poster );

        holder.movie_tittle.setText(currentItem.getTitle());
        holder.poster.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Trailer_dialog_activity.class);
            Bundle mBundle = new Bundle();
            mBundle.putInt("movie_id_trailer", (int) currentItem.getId());
            intent.putExtras(mBundle);
            v.getContext().startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
