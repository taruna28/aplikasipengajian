package com.example.aplikasipengajian;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
//dokumentasi

    MenuPengajian menuPengajian = new MenuPengajian();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl("https://app-pengajian.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static PengajianApi pengajianApi = retrofit.create(PengajianApi.class);

    public static PengajianApi getPengajianApi(){
        return pengajianApi;
    }
}
