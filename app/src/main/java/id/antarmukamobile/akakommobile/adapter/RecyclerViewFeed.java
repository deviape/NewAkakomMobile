package id.antarmukamobile.akakommobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import id.antarmukamobile.akakommobile.R;
import id.antarmukamobile.akakommobile.modelAPI.FeedModel;


/**
 * Created by asus on 17/12/2017.
 */

public class RecyclerViewFeed extends RecyclerView.Adapter<RecyclerViewFeed.ViewHolder> {
    private Context context;
    private ArrayList<FeedModel> models;

    public RecyclerViewFeed(Context context, ArrayList<FeedModel> models) {
        this.context = context;
        this.models = models;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView tvGambar;
        public TextView tvNama;
        public TextView tvKomentar;

        public ViewHolder(View v){
            super(v);
            tvGambar = (ImageView) v.findViewById(R.id.gambarOrang);
            tvNama = (TextView) v.findViewById(R.id.nama);
            tvKomentar = (TextView) v.findViewById(R.id.komentar);
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
        holder.tvGambar.setImageResource(models.get(position).getGambarId());
        holder.tvNama.setText(models.get(position).getNama());
        holder.tvKomentar.setText(models.get(position).getKomentar());
    }

    @Override
    public int getItemCount(){
        return models.size();
    }
}
