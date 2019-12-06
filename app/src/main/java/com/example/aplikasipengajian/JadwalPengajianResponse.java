package com.example.aplikasipengajian;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JadwalPengajianResponse {

     String sukses;

//    public JadwalPengajianResponse(String sukses){
//        this.sukses = sukses;
//    }


    @SerializedName("record")
    @Expose()
    private List<MenuPengajian> menuPengajians ;

    public JadwalPengajianResponse(List<MenuPengajian> list) {
        this.menuPengajians = list;
    }

    public List<MenuPengajian> getMenuPengajians() {
        return menuPengajians;
    }

    @Override
    public String toString() {
        return sukses;
    }
//    public String getSukses(){
//        return sukses;
//    }
}
