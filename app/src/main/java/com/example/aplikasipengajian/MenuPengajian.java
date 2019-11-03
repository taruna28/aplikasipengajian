package com.example.aplikasipengajian;

import android.os.Parcel;
import android.os.Parcelable;

class MenuPengajian implements Parcelable {
    public String nama;
    public String foto;

    public MenuPengajian() {
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
    }

    protected MenuPengajian(Parcel in) {
        nama = in.readString();
        foto = in.readString();
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
}
