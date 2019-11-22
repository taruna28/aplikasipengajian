package com.example.aplikasipengajian;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PengajianApi {

   @GET("pengajian/pengajian_show.php")
    Call<JadwalPengajianResponse> jadwalPengajian();

   @GET("anggota/anggota_login.php")
   //tambahin @path untuk bikin login
    Call<JadwalPengajianResponse> userLogin
    ( @Query("username") String username, @Query("password") String password);
}
