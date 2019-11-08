package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailJadwalActivity extends AppCompatActivity {
    public static final String EXTRA_FILM = "extra";
    TextView tvNamaPengajian,tvTema,tvPengisi;
    ImageView ivGambar;
//  TextView textView2;
    String namaPengajian, namaTema,gambar,pengisiAcara,myLati,latitude,myLongi,longitude;
    Button btnmaps;
    MenuPengajian menuPengajian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal);

        tvNamaPengajian = findViewById(R.id.tv_nama_pengajian2);
        tvTema = findViewById(R.id.tv_tema2);
        btnmaps = findViewById(R.id.btnMaps);
        tvPengisi = findViewById(R.id.tv_nama_pengisi2);
        ivGambar = findViewById(R.id.iv_gambar);

        latitude = "-6.120255";
        longitude= "106.910150";
//        getExtras
        menuPengajian = getIntent().getParcelableExtra(EXTRA_FILM);

        namaTema = menuPengajian.getNama_pengajian();
        namaPengajian = menuPengajian.getTema();
        gambar = menuPengajian.getGambar();
        pengisiAcara= menuPengajian.getPengisi_acara();

        myLati = menuPengajian.getLatitude();
        myLongi = menuPengajian.getLongitude();

//        String kode = getIntent().getExtras().getString("Kode_pengajian");

//        getExtras
        String poster = "http://app-pengajian.000webhostapp.com/ypathfile/" + gambar;

        Glide.with(getApplicationContext())
                .load(poster)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .dontAnimate()
                .into(ivGambar);



//        textView1.setText(kode);
        tvNamaPengajian.setText(namaTema);
        tvTema.setText(namaPengajian);
        tvPengisi.setText(pengisiAcara);
        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String modeDirection = "driving";
                String url = "http://maps.google.com/maps?saddr="+latitude+","+longitude+"&daddr="+myLati+","+myLongi+"&directionsmode=" + modeDirection;
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);

//                Intent intent = new Intent(DetailJadwalActivity.this,MapsActivity.class);
//                startActivity(intent);

            }
        });
    }
}
