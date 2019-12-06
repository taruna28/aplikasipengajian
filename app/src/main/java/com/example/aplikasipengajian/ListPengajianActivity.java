package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPengajianActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MenuPengajian> list = new ArrayList<>();
    private List<JadwalPengajianResponse> mCategoryDataList = new ArrayList<>();
    ListJadwalAdapter listJadwalAdapter;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pengajian);

//        recyclerView = findViewById(R.id.rv_jadwal_pengajian);
//        recyclerView.setHasFixedSize(true);
//
//        list.addAll(getListMenu());
//        showRecyclerList();
        view();
        testRetrofitRequest();
    }
    private void view(){
        recyclerView = findViewById(R.id.rv_jadwal_pengajian);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }



//    public ArrayList<MenuPengajian> getListMenu(){
//        String[] dataName = getResources().getStringArray(R.array.data_name);
//        String[] photo = getResources().getStringArray(R.array.data_photo);
//
//        ArrayList<MenuPengajian> listMenu = new ArrayList<>();
//        for (int i=0;i<dataName.length;i++){
//            MenuPengajian menu = new MenuPengajian();
//            menu.setNama(dataName[i]);
//            menu.setFoto(photo[i]);
//
//            listMenu.add(menu);
//        }
//        return listMenu;
//    }
//
//    private void showRecyclerList(){
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        ListJadwalAdapter pengajianAdapter = new ListJadwalAdapter(this,list);
//        recyclerView.setAdapter(pengajianAdapter);
//    }

    public void testRetrofitRequest(){
        PengajianApi pengajianApi = ServiceGenerator.getPengajianApi();
        Call<JadwalPengajianResponse> responseCall = pengajianApi.jadwalPengajian();
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Menyiapkan data");
        progressDialog.show();
        progressDialog.setCancelable(false);
        responseCall.enqueue(new Callback<JadwalPengajianResponse>() {
            @Override
            public void onResponse(Call<JadwalPengajianResponse> call, Response<JadwalPengajianResponse> response) {

                if (response.isSuccessful()){
                    try {
//                        Log.d(TAG, "onResponse sukses: "+response.body().getMenuPengajians());

                        int total = response.body().getMenuPengajians().size();

                        for (int a=0; a<total;a++){
                            MenuPengajian model = new MenuPengajian(
                                    response.body().getMenuPengajians().get(a).getKode_pengajian(),
                                   response.body().getMenuPengajians().get(a).getNama_pengajian(),
                                    response.body().getMenuPengajians().get(a).getTema(),
                                    response.body().getMenuPengajians().get(a).getDeskripsi(),
                                    response.body().getMenuPengajians().get(a).getPenyelenggara(),
                                    response.body().getMenuPengajians().get(a).getPengisi_acara(),
                                    response.body().getMenuPengajians().get(a).getAlamat(),
                                    response.body().getMenuPengajians().get(a).getLatitude(),
                                    response.body().getMenuPengajians().get(a).getLongitude(),
                                    response.body().getMenuPengajians().get(a).getKeterangan(),
                                    response.body().getMenuPengajians().get(a).getTgl_posting(),
                                    response.body().getMenuPengajians().get(a).getTgl_pelaksanaan(),
                                    response.body().getMenuPengajians().get(a).getJam_pelaksanaan(),
                                    response.body().getMenuPengajians().get(a).getUlasan(),
                                    response.body().getMenuPengajians().get(a).getStatus(),
                                    response.body().getMenuPengajians().get(a).getGambar());
                                   list.add(model);
                        }

                        JadwalPengajianResponse item = new JadwalPengajianResponse(list);
                        mCategoryDataList.add(item);
                        Log.d(TAG, "onResponse listpengajianactivity: "+mCategoryDataList);

                        listJadwalAdapter = new ListJadwalAdapter(ListPengajianActivity.this,list);
                        recyclerView.setAdapter(listJadwalAdapter);

                    }catch (NullPointerException e){
                        e.printStackTrace();
                    }

                }
                progressDialog.dismiss();
             }

            @Override
            public void onFailure(Call<JadwalPengajianResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: gagal");
                Toast.makeText(ListPengajianActivity.this, "Koneksi jaringan bermasalah", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

}
