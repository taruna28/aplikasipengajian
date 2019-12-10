package com.taruna.aplikasipengajian;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PengajianApi {

   @GET("pengajian/pengajian_show.php")
    Call<JadwalPengajianResponse> jadwalPengajian();

   @GET("anggota/anggota_login.php")
   //tambahin @path untuk bikin login
    Call<JadwalPengajianResponse> userLogin
    ( @Query("username") String username, @Query("password") String password);

    @FormUrlEncoded
   @POST("anggota/anggota_add.php")
    Call<ResponseBody> userRegister(
            @Field("nama_anggota") String nama_anggota,
            @Field("telepon") String telepon,
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password
   );
}
