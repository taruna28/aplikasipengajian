package com.taruna.aplikasipengajian;

import androidx.annotation.NonNull;

public class LoginResponse {

    private String sukses;

    public LoginResponse(String sukses){
        this.sukses = sukses;
    }

    @NonNull
    @Override
    public String toString() {
        return sukses;
    }
}
