package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailJadwalActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal);

        textView = findViewById(R.id.detail_test);

        String kode = getIntent().getExtras().getString("Kode_pengajian");

        textView.setText(kode);
    }
}
