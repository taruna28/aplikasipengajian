package com.example.aplikasipengajian;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
