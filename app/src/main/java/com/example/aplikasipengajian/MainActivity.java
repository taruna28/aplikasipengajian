package com.example.aplikasipengajian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<MenuPengajian> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_pengajian);
        recyclerView.setHasFixedSize(true);

        list.addAll(getListMenu());
        showRecyclerList();
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PengajianAdapter pengajianAdapter = new PengajianAdapter(list);
        recyclerView.setAdapter(pengajianAdapter);
    }
}
