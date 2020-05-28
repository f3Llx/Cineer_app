package com.example.cineer.Movies_Search;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cineer.Movies_Popular.Movies_popular_results;
import com.example.cineer.Movies_info.Movies_info;
import com.example.cineer.R;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ExampleViewHolder> {
    private ArrayList<Movies_results> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        // public ImageView mImageView;
        // public TextView mTextView1;
        // public TextView mTextView2;
        public TextView movie_tittle;
        public ImageView image,getImage;
        public ConstraintLayout layout;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            //mImageView = itemView.findViewById(R.id.imageView);
            //mTextView1 = itemView.findViewById(R.id.textView);
            //mTextView2 = itemView.findViewById(R.id.textView2);
            movie_tittle = itemView.findViewById(R.id.nombre_peli);
            image = itemView.findViewById(R.id.search_img_item);
            getImage=itemView.findViewById(R.id.get_drawable2);
            layout=itemView.findViewById(R.id.item_layout_search);


        }
    }

    public SearchAdapter(ArrayList<Movies_results> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Movies_results currentItem = mExampleList.get(position);
        //holder.mImageView.setImageResource(currentItem.getImageResource());
        //holder.mTextView1.setText(currentItem.getText1());
        //holder.mTextView2.setText(currentItem.getText2());
        holder.movie_tittle.setText(currentItem.getTitle());

        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(0)
                .cornerRadiusDp(720)
                .oval(false)
                .build();

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+currentItem.getPoster_path() )
                .noPlaceholder().fit().transform(transformation)
                .into( holder.image );

        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+currentItem.getBackdrop_path() )
                .noPlaceholder().fit()
                .into(holder.getImage, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        holder.layout.setBackgroundDrawable(holder.getImage.getDrawable());
                        Log.i("TAG", "funciono");
                    }
                    @Override
                    public void onError(Exception e) {
                        Log.i("TAG", "no"+e.toString());
                    }
                });

       //Picasso.get()
       //        .load("https://image.tmdb.org/t/p/w500/"+currentItem.getPoster_path())
       //        .fit()
       //        .into(holder.getImage, new com.squareup.picasso.Callback() {
       //            @Override
       //            public void onSuccess() {
       //                holder.layout.setBackgroundDrawable(holder.getImage.getDrawable());
       //                Log.i("TAG", "funciono");
       //            }
       //            @Override
       //            public void onError(Exception e) {
       //                Log.i("TAG", "no"+e.toString());
       //            }
       //        });

        holder.movie_tittle.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Movies_info.class);
            Bundle mBundle = new Bundle();
            mBundle.putInt("movie_id", (int) currentItem.getId());
            intent.putExtras(mBundle);
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {


        if (mExampleList != null) {
            if (mExampleList.size() > 5)
                return 5;
            return mExampleList.size();
        }
        return 0;








    }
}
