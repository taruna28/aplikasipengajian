package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button buttonLogin;
    private static final String TAG = "LoginActivity";
    private List<MenuPengajian> list = new ArrayList<>();
    private List<JadwalPengajianResponse> mCategoryDataList = new ArrayList<>();

    String kode_anggota="",nama_anggota,email,sukses;
    EditText txtusername,txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.btn_sign_in);

        txtusername=findViewById(R.id.edtUser);
        txtpassword=findViewById(R.id.edtPassword);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=txtusername.getText().toString();
                String pass=txtpassword.getText().toString();
                if(user.length()<1){lengkapi("Username");}
                else if(pass.length()<1){lengkapi("Password");}
                else{
                        login(user,pass);

                }


//                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
            }
        });

    }
    public void login(String username,String password){
        PengajianApi pengajianApi = ServiceGenerator.getPengajianApi();
        Call<JadwalPengajianResponse> jadwalPengajianResponseCall = pengajianApi.userLogin(username,password);
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Menyiapkan data");
        progressDialog.show();
        progressDialog.setCancelable(false);
        jadwalPengajianResponseCall.enqueue(new Callback<JadwalPengajianResponse>() {
            @Override
            public void onResponse(Call<JadwalPengajianResponse> call, Response<JadwalPengajianResponse> response) {

                sukses= response.body().toString();
                Log.d(TAG, "onResponse: "+ response.body());
                if (response.code()==200){
                    Log.d(TAG, "onResponse: "+response.body().toString());

                    if (response.body().toString().equals("1")) {
                        Log.d(TAG, "onResponse: ini masuk 1");
                        List<MenuPengajian> menuPengajians = new ArrayList<>(response.body().getMenuPengajians());
                        for (MenuPengajian pengajian : menuPengajians) {
//                            pengajian.getKode_anggota();
                            String kode= pengajian.getKode_anggota();
                            Log.d(TAG, "onResponse: "+kode);
                            Log.d(TAG, "onResponse: "+pengajian.getSukses());
                            }
//                            Log.d(TAG, "onResponse: " + kode_anggota+" "+nama_anggota+""+email);
//                            list.add()
                            ;
                        sharedPref();
                        }else {
                        gagal("login");
                    }

//                    JadwalPengajianResponse item = new JadwalPengajianResponse(list);
//                    mCategoryDataList.add(item);
//                    }
                }
                else {
                    try {
                        Log.d(TAG, "onResponse 3: "+response.errorBody().string());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JadwalPengajianResponse> call, Throwable t) {

            }
        });
    }

    protected void sharedPref() {

        Log.v("SUKSES",kode_anggota);



            final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("Registered", true);
            editor.putString("kode_anggota", kode_anggota);
            editor.putString("nama_anggota", nama_anggota);
            editor.putString("email", email);
            editor.apply();
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
    }
    public void gagal(String item){
        new AlertDialog.Builder(this)
                .setTitle("Gagal Login")
                .setMessage("Login "+item+" ,, Gagal")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                    }})
                .show();
    }
    public void lengkapi(String item){
        new AlertDialog.Builder(this)
                .setTitle("Lengkapi Data")
                .setMessage("Silakan lengkapi data "+item)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                    }})
                .show();
    }
}
