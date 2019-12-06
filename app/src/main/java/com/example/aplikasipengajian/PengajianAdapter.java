package com.example.aplikasipengajian;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PengajianAdapter extends RecyclerView.Adapter<PengajianAdapter.GridViewHolder>{
    private ArrayList<MenuPengajian> pengajianArrayList;
    Context mContext;

    public PengajianAdapter(Context context,ArrayList<MenuPengajian> list){
        this.pengajianArrayList = list;
        mContext = context;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu,parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        final MainActivity mainActivity = new MainActivity();
        MenuPengajian menuPengajian= pengajianArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(menuPengajian.getFoto())
                .apply(new RequestOptions().override(550,550))
                .into(holder.imgPhoto);

        holder.tvName.setText(menuPengajian.getNama());


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
            tvName = itemView.findViewById(R.id.tv_nama_pengajian);
            constraintLayout = itemView.findViewById(R.id.parent_layout);
            ucontext = itemView.getContext();
            constraintLayout.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    intent =  new Intent(ucontext, ListPengajianActivity.class);
                    break;

                case 1:
                    intent =  new Intent(ucontext, MapsActivity.class);
                    break;

                default:
                    intent =  new Intent(ucontext, Menu_utama.class);
                    break;
            }
            ucontext.startActivity(intent);
        }
    }


}
