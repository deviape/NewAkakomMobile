package id.antarmukamobile.akakommobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import id.antarmukamobile.akakommobile.R;
import id.antarmukamobile.akakommobile.ui.TautanWebView;

/**
 * Created by Yudis on 11/23/2017.
 */

public class RecyclerViewAdapterTautan extends RecyclerView.Adapter<RecyclerViewAdapterTautan.ViewHolder> {

    Context context;
    ArrayList<String> linkList;
    ArrayList<String> namaLink;

    public RecyclerViewAdapterTautan(Context context, ArrayList<String> linkList, ArrayList<String> namaLink) {
        this.context = context;
        this.linkList = linkList;
        this.namaLink = namaLink;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewAdapterTautan.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_tautan,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViewLink.setText(namaLink.get(position));
        holder.textViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TautanWebView.class);
                intent.putExtra("link",linkList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return linkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewLink;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewLink = (TextView)itemView.findViewById(R.id.textLink);
        }
    }
}
