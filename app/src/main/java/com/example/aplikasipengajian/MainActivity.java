package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<MenuPengajian> list = new ArrayList<>();
    String kode_anggota, nama_anggota;

    private static final String TAG = "MainActivity";
//    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_pengajian);
        recyclerView.setHasFixedSize(true);

        list.addAll(getListMenu());
        showRecyclerList();
//
//        session = new SessionManager(getApplicationContext());
//        session.checkLogin();

//        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
//        Boolean Registered = sharedPref.getBoolean("Registered", false);
//        if (!Registered){
//            finish();
//        }else {
//            kode_anggota= sharedPref.getString("kode_anggota", "");
//            nama_anggota = sharedPref.getString("nama_anggota", "");
//        }
//    }


//        SharedPreferences preferences = getSharedPreferences(PREF_LOGIN, MODE_PRIVATE);
//
//        Intent intent = null;
//        if(preferences.contains(KEY_CREDENTIALS)){              //if user is currently logged in;
//            intent = new Intent(this, MainActivity.class);
//        }else {                                                 //if user is not yet logged in;
//            intent = new Intent(this, LoginActivity.class);
//        }
//        startActivity(intent);
    }

    public ArrayList<MenuPengajian> getListMenu(){
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] photo = getResources().getStringArray(R.array.data_photo);

    ArrayList<MenuPengajian> listMenu = new ArrayList<>();
    for (int i=0;i<dataName.length;i++){
        MenuPengajian menu = new MenuPengajian();
        menu.setNama(dataName[i]);
        menu.setFoto(photo[i]);

        listMenu.add(menu);
        }
    return listMenu;
    }

    private void showRecyclerList(){
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        PengajianAdapter pengajianAdapter = new PengajianAdapter(this,list);
        recyclerView.setAdapter(pengajianAdapter);
    }

    public void testRetrofitRequest(){
        PengajianApi pengajianApi = ServiceGenerator.getPengajianApi();

        Call<JadwalPengajianResponse> responseCall = pengajianApi.jadwalPengajian();

        responseCall.enqueue(new Callback<JadwalPengajianResponse>() {
            @Override
            public void onResponse(Call<JadwalPengajianResponse> call, Response<JadwalPengajianResponse> response) {
                Log.d(TAG, "onResponse: "+ response.toString());
                if (response.code()==200){
                    Log.d(TAG, "onResponse: "+response.body().toString());
                    List<MenuPengajian> menuPengajians = new ArrayList<>(response.body().getMenuPengajians());
                    for (MenuPengajian pengajian : menuPengajians){
                        Log.d(TAG, "onResponse: "+pengajian.getKode_pengajian());
                    }
                }
                else {
                    try {
                        Log.d(TAG, "onResponse: "+response.errorBody().string());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JadwalPengajianResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: gagal");
            }
        });
    }

}
