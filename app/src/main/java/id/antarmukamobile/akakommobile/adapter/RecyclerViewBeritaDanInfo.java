package id.antarmukamobile.akakommobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import id.antarmukamobile.akakommobile.DetailBeritaActivity;
import id.antarmukamobile.akakommobile.R;

/**
 * Created by kikiosha on 12/14/17.
 */

public class RecyclerViewBeritaDanInfo extends RecyclerView.Adapter<RecyclerViewBeritaDanInfo.ViewHolder> {
    Context context;
    ArrayList<String> authorBerita;
    ArrayList<String> judulBerita;
    ArrayList<String> linkBerita;
    String status;

    public RecyclerViewBeritaDanInfo(Context context, ArrayList<String> authorBerita, ArrayList<String> judulBerita, ArrayList<String> linkBerita, String status) {
        this.context = context;
        this.authorBerita = authorBerita;
        this.judulBerita = judulBerita;
        this.linkBerita = linkBerita;
        this.status = status;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewBeritaDanInfo.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_berita_dan_info, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewAuthor.setText(authorBerita.get(position));
        holder.textViewJudul.setText(judulBerita.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status.equals("berita")){
                    Intent intent=new Intent(context, DetailBeritaActivity.class);
                    intent.putExtra("link", linkBerita.get(position));
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return authorBerita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewAuthor, textViewJudul;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewAuthor=(TextView)itemView.findViewById(R.id.authorBerita);
            textViewJudul=(TextView)itemView.findViewById(R.id.judulBerita);
            cardView=(CardView)itemView.findViewById(R.id.cardviewBerita);
        }
    }
}
