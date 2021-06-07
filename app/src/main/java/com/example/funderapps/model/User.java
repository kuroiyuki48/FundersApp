package com.example.funderapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @Expose
    @SerializedName("id") int id;
    @Expose
    @SerializedName("name") String name;
    @Expose
    @SerializedName("email") String email;
    @Expose
    @SerializedName("no_telp") String no_telp;
    @Expose
    @SerializedName("deskripsi") String deskripsi;
    @Expose
    @SerializedName("id_kabkota") String id_kabkota;
    @Expose
    @SerializedName("alamat") String alamat;
    @Expose
    @SerializedName("gambar") String gambar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String geNoTelp() {
        return no_telp;
    }

    public void setNoTelp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getIdKabkota() {
        return id_kabkota;
    }

    public void setIdKabkota(String id_kabkota) {
        this.id_kabkota = id_kabkota;
    }

    public String getAlamat() { return alamat; }

    public void setAlamat(String alamat) {
        this.alamat = email;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
