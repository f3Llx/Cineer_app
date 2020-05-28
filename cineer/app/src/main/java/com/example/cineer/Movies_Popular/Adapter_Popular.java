package com.example.cineer.Movies_Popular;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.animation.AnimationUtils;
        import android.widget.ImageView;
        import android.widget.RatingBar;
        import android.widget.TextView;
        import androidx.recyclerview.widget.RecyclerView;
        import com.example.cineer.Movies_info.Movies_info;
        import com.example.cineer.R;
        import com.squareup.picasso.Picasso;
        import org.jetbrains.annotations.NotNull;
        import java.util.ArrayList;

public class Adapter_Popular extends RecyclerView.Adapter<Adapter_Popular.ExampleViewHolder> {
    private ArrayList<Movies_popular_results> mExampleList;
    static class ExampleViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView movie_tittle;
        RatingBar ratingBar;


        ExampleViewHolder(View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.movie_popular_poster);
            ratingBar=itemView.findViewById(R.id.ratingBar_popular);
            movie_tittle = itemView.findViewById(R.id.movie_popular_tittle);
        }
    }
    Adapter_Popular(ArrayList<Movies_popular_results> exampleList) {
        mExampleList = exampleList;
    }
    @NotNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_popular_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Movies_popular_results currentItem = mExampleList.get(position);
        Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+currentItem.getPoster_path() )
                .noPlaceholder()
                .into( holder.poster );
        holder.ratingBar.setRating(currentItem.getVote_average()/2);
        holder.movie_tittle.setText(currentItem.getTitle());
        holder.poster.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Movies_info.class);
            Bundle mBundle = new Bundle();
            mBundle.putInt("movie_id", (int) currentItem.getId());
            intent.putExtras(mBundle);
            v.getContext().startActivity(intent);

        });
    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}