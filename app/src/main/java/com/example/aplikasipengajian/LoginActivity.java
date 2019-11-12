package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;

public class LoginActivity extends AppCompatActivity {
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.btn_sign_in);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void login(String username,String password){
        PengajianApi pengajianApi = ServiceGenerator.getPengajianApi();
        Call<JadwalPengajianResponse> jadwalPengajianResponseCall = pengajianApi.userLogin(username,password);
    }
}
