package id.antarmukamobile.akakommobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;
import id.antarmukamobile.akakommobile.R;
import id.antarmukamobile.akakommobile.modelAPI.FeedBackFirebaseModel;
import id.antarmukamobile.akakommobile.modelAPI.FeedModel;


/**
 * Created by asus on 17/12/2017.
 */

public class RecyclerViewFeed extends RecyclerView.Adapter<RecyclerViewFeed.ViewHolder> {
    private Context context;
    private ArrayList<FeedBackFirebaseModel> models;

    public RecyclerViewFeed(Context context, ArrayList<FeedBackFirebaseModel> models) {
        this.context = context;
        this.models = models;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView tvGambar;
        public TextView tvNama;
        public TextView tvKomentar;
        public RatingBar ratingBar;

        public ViewHolder(View v){
            super(v);
            tvGambar = (ImageView) v.findViewById(R.id.gambarOrang);
            tvNama = (TextView) v.findViewById(R.id.nama);
            tvKomentar = (TextView) v.findViewById(R.id.komentar);
            ratingBar = (RatingBar)v.findViewById(R.id.ratingBar);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_view, null);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position){
        holder.tvNama.setText(models.get(position).getNama());
        holder.tvKomentar.setText(models.get(position).getKomentar());
        holder.ratingBar.setRating(models.get(position).getRating());
    }

    @Override
    public int getItemCount(){
        return models.size();
    }
}
