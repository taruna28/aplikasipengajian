package com.example.aplikasipengajian;

import android.os.Parcel;
import android.os.Parcelable;

class MenuPengajian implements Parcelable {

    public String nama;
    public String foto;

    public String sukses;
    public String kode_anggota;
    public String nama_anggota;
    public String email;

    public String username;
    public String password;
    public String kode_pengajian;
    public String nama_pengajian;
    public String tema;
    public String deskripsi;
    public String penyelenggara;
    public String pengisi_acara;
    public String alamat;
    public String latitude;
    public String longitude;
    public String keterangan;
    public String tgl_posting;
    public String tgl_pelaksanaan;
    public String jam_pelaksanaan;
    public String ulasan;
    public String status;
    public String gambar;

    public MenuPengajian(String kode_anggota,String nama_anggota,String email) {
        this.kode_anggota = kode_anggota;
        this.nama_anggota = nama_anggota;
        this.email = email;
    }

    public MenuPengajian(){

    }
    protected MenuPengajian(Parcel in) {
        nama = in.readString();
        foto = in.readString();
        kode_pengajian = in.readString();
        nama_pengajian = in.readString();
        tema = in.readString();
        deskripsi = in.readString();
        penyelenggara = in.readString();
        pengisi_acara = in.readString();
        alamat = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        keterangan = in.readString();
        tgl_posting = in.readString();
        tgl_pelaksanaan = in.readString();
        jam_pelaksanaan = in.readString();
        ulasan = in.readString();
        status = in.readString();
        gambar = in.readString();
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<MenuPengajian> CREATOR = new Creator<MenuPengajian>() {
        @Override
        public MenuPengajian createFromParcel(Parcel in) {
            return new MenuPengajian(in);
        }

        @Override
        public MenuPengajian[] newArray(int size) {
            return new MenuPengajian[size];
        }
    };

    public MenuPengajian(String kode_pengajian, String nama_pengajian, String tema, String deskripsi, String penyelenggara, String pengisi_acara, String alamat, String latitude, String longitude, String keterangan, String tgl_posting, String tgl_pelaksanaan, String jam_pelaksanaan, String ulasan, String status, String gambar) {
        this.kode_pengajian = kode_pengajian;
        this.nama_pengajian = nama_pengajian;
        this.tema = tema;
        this.deskripsi = deskripsi;
        this.penyelenggara = penyelenggara;
        this.pengisi_acara = pengisi_acara;
        this.alamat = alamat;
        this.latitude = latitude;
        this.longitude = longitude;
        this.keterangan = keterangan;
        this.tgl_posting = tgl_posting;
        this.tgl_pelaksanaan = tgl_pelaksanaan;
        this.jam_pelaksanaan = jam_pelaksanaan;
        this.ulasan = ulasan;
        this.status = status;
        this.gambar = gambar;
    }

    public String getKode_anggota() {
        return kode_anggota;
    }

    public void setKode_anggota(String kode_anggota) {
        this.kode_anggota = kode_anggota;
    }

    public String getNama_anggota() {
        return nama_anggota;
    }

    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MenuPengajian(String latitude, String longitude) {
    }

    public String getSukses() {
        return sukses;
    }

    public void setSukses(String sukses) {
        this.sukses = sukses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getKode_pengajian() {
        return kode_pengajian;
    }

    public void setKode_pengajian(String kode_pengajian) {
        this.kode_pengajian = kode_pengajian;
    }

    public String getNama_pengajian() {
        return nama_pengajian;
    }

    public void setNama_pengajian(String nama_pengajian) {
        this.nama_pengajian = nama_pengajian;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getPenyelenggara() {
        return penyelenggara;
    }

    public void setPenyelenggara(String penyelenggara) {
        this.penyelenggara = penyelenggara;
    }

    public String getPengisi_acara() {
        return pengisi_acara;
    }

    public void setPengisi_acara(String pengisi_acara) {
        this.pengisi_acara = pengisi_acara;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTgl_posting() {
        return tgl_posting;
    }

    public void setTgl_posting(String tgl_posting) {
        this.tgl_posting = tgl_posting;
    }

    public String getTgl_pelaksanaan() {
        return tgl_pelaksanaan;
    }

    public void setTgl_pelaksanaan(String tgl_pelaksanaan) {
        this.tgl_pelaksanaan = tgl_pelaksanaan;
    }

    public String getJam_pelaksanaan() {
        return jam_pelaksanaan;
    }

    public void setJam_pelaksanaan(String jam_pelaksanaan) {
        this.jam_pelaksanaan = jam_pelaksanaan;
    }

    public String getUlasan() {
        return ulasan;
    }

    public void setUlasan(String ulasan) {
        this.ulasan = ulasan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(foto);
        dest.writeString(kode_pengajian);
        dest.writeString(nama_pengajian);
        dest.writeString(tema);
        dest.writeString(deskripsi);
        dest.writeString(penyelenggara);
        dest.writeString(pengisi_acara);
        dest.writeString(alamat);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(keterangan);
        dest.writeString(tgl_posting);
        dest.writeString(tgl_pelaksanaan);
        dest.writeString(jam_pelaksanaan);
        dest.writeString(ulasan);
        dest.writeString(status);
        dest.writeString(gambar);
        dest.writeString(username);
        dest.writeString(password);
    }
}