package com.example.cineer.Movies_info;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cineer.Movies_Popular.Movies_popular_results;
import com.example.cineer.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapter_Detalle extends RecyclerView.Adapter<Adapter_Detalle.ExampleViewHolder> {
    private ArrayList<Movies_Review> movies_reviews;
    static class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView author_review;
        ExpandableTextView expTv1;
        ImageButton urlbtn;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            author_review = itemView.findViewById(R.id.author_review);
            expTv1= itemView.findViewById(R.id.expand_text_view);
            urlbtn=itemView.findViewById(R.id.url_btn);

        }
    }
    Adapter_Detalle(ArrayList<Movies_Review> exampleList) {
        movies_reviews = exampleList;
    }
    @NotNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Movies_Review currentItem = movies_reviews.get(position);
        holder.author_review.setText(currentItem.getAuthor());
        holder.expTv1.setText(currentItem.getContent());
        holder.urlbtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse(currentItem.getUrl()));
            v.getContext().startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return movies_reviews.size();
    }
}