package com.example.aplikasipengajian;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PengajianApi {

   @GET("pengajian/pengajian_show.php")
    Call<JadwalPengajianResponse> jadwalPengajian();
}
