package com.example.funderapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.funderapps.network.response.RecommendationResult;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;

    private List<RecommendationResult> reccommended;

    public RecyclerAdapter(Context context, List<RecommendationResult> reccommended) {
        this.context = context;
        this.reccommended = reccommended;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText(reccommended.get(position).getName());
        holder.tvLokasi.setText(reccommended.get(position).getLokasi());
        holder.tvKategori.setText(reccommended.get(position).getKategori());
    }

    @Override
    public int getItemCount() {
        return reccommended.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_recommended)
        LinearLayout parentMovieCard;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvLokasi)
        TextView tvLokasi;

        @BindView(R.id.tvKategori)
        TextView tvKategori;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public List<RecommendationResult> getRecommended(){
        return reccommended;
    }
}