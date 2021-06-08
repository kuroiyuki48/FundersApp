package com.example.funderapps.network.response;

import com.example.funderapps.model.Dataset;
import com.example.funderapps.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileResponse extends BaseResponse {

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
    @SerializedName("lokasi") String lokasi;
    @Expose
    @SerializedName("kategori") String kategori;
    @Expose
    @SerializedName("range_fund") String range_fund;
    @Expose
    @SerializedName("range_employee") String range_employee;


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


    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }


    public String getKategori() {
        return kategori;
    }

    public void setkategori(String kategori) {
        this.kategori = kategori;
    }


    public String getRangeFund() {
        return range_fund;
    }

    public void setRangeFund(String range_fund) {
        this.range_fund = range_fund;
    }


    public String getRangeEmployee() {
        return range_employee;
    }

    public void setRangeEmployee(String range_employee) {
        this.range_employee = this.range_employee;
    }
}
