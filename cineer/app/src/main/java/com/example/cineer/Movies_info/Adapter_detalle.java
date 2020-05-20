package com.example.cineer.Movies_info;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cineer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_detalle extends RecyclerView.Adapter<Adapter_detalle.ExampleViewHolder> {
    private Movies_Popular_Details mInfo_List;

    static class ExampleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView title, subtitle, budget, homepage, original_languaje, original_title, overview, release_date, runtime;

        ExampleViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.tv_Title);
            subtitle = itemView.findViewById(R.id.tv_Tagline);
            budget = itemView.findViewById(R.id.budget);
            homepage = itemView.findViewById(R.id.homepage);
            original_languaje = itemView.findViewById(R.id.original_language);
            original_title = itemView.findViewById(R.id.original_title);
            overview = itemView.findViewById(R.id.overview);
            release_date = itemView.findViewById(R.id.release_date);
            runtime = itemView.findViewById(R.id.runtime);
        }
    }

    public Adapter_detalle(Movies_Popular_Details mInfo_List) {
        this.mInfo_List = mInfo_List;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_movies_info, parent, false);
        Adapter_detalle.ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Movies_Popular_Details moviesPopularDetails = mInfo_List;

        Picasso.get().load(moviesPopularDetails.getPoster_path()).into(holder.iv);
        holder.title.setText(moviesPopularDetails.getTitle());
        holder.subtitle.setText(moviesPopularDetails.getTagline());
        holder.budget.setText(moviesPopularDetails.getBudget());
        holder.homepage.setText(moviesPopularDetails.getHomepage());
        holder.original_languaje.setText(moviesPopularDetails.getOriginal_language());
        holder.original_title.setText(moviesPopularDetails.getOriginal_title());
        holder.overview.setText(moviesPopularDetails.getOverview());
        holder.release_date.setText(moviesPopularDetails.getRelease_date());
        holder.runtime.setText(moviesPopularDetails.getRuntime());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}

