package com.example.funderapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dataset {

    @Expose
    @SerializedName("lokasi") String lokasi;
    @Expose
    @SerializedName("kategori") String kategori;
    @Expose
    @SerializedName("range_fund") String range_fund;
    @Expose
    @SerializedName("range_employee") String range_employee;

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getRange_Fund() {
        return range_fund;
    }

    public void setRange_Fund(String range_fund) {
        this.range_fund = Dataset.this.range_fund;
    }

    public String getRange_Employee() {
        return range_employee;
    }

    public void setRange_Employee(String range_employee) {
        this.range_employee = Dataset.this.range_employee;
    }
}
