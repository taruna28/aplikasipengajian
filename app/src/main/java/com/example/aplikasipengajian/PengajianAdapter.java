package com.example.aplikasipengajian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PengajianAdapter extends RecyclerView.Adapter<PengajianAdapter.GridViewHolder>{
    private ArrayList<MenuPengajian> pengajianArrayList;

    public PengajianAdapter(ArrayList<MenuPengajian> list){
        this.pengajianArrayList = list;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        MenuPengajian menuPengajian= pengajianArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(menuPengajian.getFoto())
                .apply(new RequestOptions().override(550,550))
                .into(holder.imgPhoto);

        holder.tvName.setText(menuPengajian.getNama());
    }

    @Override
    public int getItemCount() {
        return pengajianArrayList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        public GridViewHolder(@NonNull View itemView) {
            //karena ada konstruktor parent
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_pengajian);

        }
    }
}
