package com.example.funderapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfile {

    @Expose
    @SerializedName("token") String token;
    @Expose
    @SerializedName("name") String name;
    @Expose
    @SerializedName("email") String email;
    @Expose
    @SerializedName("role") String role;
    @Expose
    @SerializedName("provinsi") String provinsi;
    @Expose
    @SerializedName("kabkota") String kabkota;
    @Expose
    @SerializedName("dataset")
    Dataset dataset;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }


    public String getKabkota() {
        return kabkota;
    }

    public void setKabkota(String kabkota) {
        this.kabkota = kabkota;
    }


    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }
}
