package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText edtUserName,edtEmail,edtTelepon,edtNama,edtPassword;
    Button kirim,batal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUserName = findViewById(R.id.edtUser);
        edtEmail = findViewById(R.id.edtEmail);
        edtTelepon = findViewById(R.id.edtTelepon);
        edtNama = findViewById(R.id.edtNama);
        edtPassword = findViewById(R.id.edtPassword);

        batal = findViewById(R.id.btn_batal);
        kirim = findViewById(R.id.btn_kirim);
        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kirimData();
            }
        });

        batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    private void kirimData(){
        String username = edtUserName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String telepon = edtTelepon.getText().toString().trim();
        String nama = edtNama.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        PengajianApi pengajianApi = ServiceGenerator.getPengajianApi();
        Call<ResponseBody> responseCall = pengajianApi.userRegister(username,email,telepon,nama,password);
        responseCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RegisterActivity.this, "berhasil", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "gagal", Toast.LENGTH_SHORT).show();
            }
        });

//        ApiService apiService = Client.getInstanceRetrofit();
//        Call<ResponseBody> call = apiService.addNewDestination(
//                namaWisata,
//                kotaWisata,
//                jenisWisata,
//                gambarWisata,
//                deskripsi
//        );
//        call.enqueue

    }
}
