package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailJadwalActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal);

        textView = findViewById(R.id.detail_test);

        String kode = getIntent().getExtras().getString("kode_pengajian");

        textView.setText(kode);
    }
}
