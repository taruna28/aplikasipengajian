package com.example.aplikasipengajian;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JadwalPengajianResponse {

    @SerializedName("record")
    @Expose()
    private List<MenuPengajian> menuPengajians;

    public List<MenuPengajian> getMenuPengajians() {
        return menuPengajians;
    }

    @Override
    public String toString() {
        return "JadwalPengajianResponse{" +
                "menuPengajians=" + menuPengajians +
                '}';
    }
}
