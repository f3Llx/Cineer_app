package com.example.cineer.Movies_Search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cineer.R;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    //private final ArrayList<Movies_results> movies;
    ArrayList<Movies_results> results;
    private Context context;

    public SearchAdapter(ArrayList<Movies_results> movies) {
            //this.context = context;
            results = movies;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false);
        SearchViewHolder holder = new SearchViewHolder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Movies_results moviesResults = results.get(position);
        holder.nombre_peli.setText(moviesResults.getTitle());


    }

    @Override
    public int getItemCount() {


        return results.size();
    }

    static class SearchViewHolder extends RecyclerView.ViewHolder {



        TextView nombre_peli;
        SearchViewHolder(View itemView) {
            super(itemView);
                nombre_peli = itemView.findViewById(R.id.nombre_peli);
        }
    }
}
