package com.example.aplikasipengajian;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ListJadwalAdapter extends RecyclerView.Adapter<ListJadwalAdapter.GridViewHolder>{
    private List<MenuPengajian> pengajianArrayList;
    Context mContext;
    ListPengajianActivity listPengajianActivity = new ListPengajianActivity();

    public ListJadwalAdapter(Context context, List<MenuPengajian> list){
        this.pengajianArrayList = list;
        mContext = context;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
//        final MainActivity mainActivity = new MainActivity();
        MenuPengajian menuPengajian= pengajianArrayList.get(position);
//        Glide.with(holder.itemView.getContext())
//                .load(menuPengajian.getFoto())
//                .apply(new RequestOptions().override(550,550))
//                .into(holder.imgPhoto);

        holder.tvName.setText(menuPengajian.getKode_pengajian());

//        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(mContext, "klik "+pengajianArrayList.get(position), Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent(mContext,ListPengajianActivity.class);
////                mContext.startActivity(intent);
//
//                mainActivity.testRetrofitRequest();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return pengajianArrayList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView imgPhoto;
        TextView tvName;
        ConstraintLayout constraintLayout;
        Context ucontext;

        public GridViewHolder(@NonNull View itemView) {
            //karena ada konstruktor parent
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_pengajian);
            constraintLayout = itemView.findViewById(R.id.parent_layout);
            ucontext = itemView.getContext();
            constraintLayout.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            final Intent intent;
            intent = new Intent(ucontext,DetailJadwalActivity.class);
            intent.putExtra("kode_pengajian",pengajianArrayList.get(getAdapterPosition()));
            ucontext.startActivity(intent);
            listPengajianActivity.testRetrofitRequest();
        }
    }


}