package com.example.funderapps.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecommendationResult implements Parcelable {

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
    @SerializedName("no_telp") String no_telp;
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


    public String getNoTelp() {
        return no_telp;
    }

    public void setNoTelp(String no_telp) {
        this.no_telp = no_telp;
    }


    public String getRangeEmployee() {
        return range_employee;
    }

    public void setRangeEmployee(String range_employee) {
        this.range_employee = this.range_employee;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.name);
        dest.writeValue(this.email);
        dest.writeValue(this.role);
        dest.writeValue(this.provinsi);
        dest.writeValue(this.lokasi);
        dest.writeValue(this.kategori);
        dest.writeValue(this.range_fund);
        dest.writeValue(this.no_telp);
        dest.writeValue(this.range_employee);
    }

    public RecommendationResult() {
    }

    protected RecommendationResult(Parcel in) {
        this.name = in.readString();
        this.email = in.readString();
        this.role = in.readString();
        this.provinsi = in.readString();
        this.kabkota = in.readString();
        this.lokasi = in.readString();
        this.kategori = in.readString();
        this.range_fund = in.readString();
        this.no_telp = in.readString();
        this.range_employee = in.readString();
    }

    public static final Creator<RecommendationResult> CREATOR = new Creator<RecommendationResult>() {
        @Override
        public RecommendationResult createFromParcel(Parcel in) {
            return new RecommendationResult(in);
        }

        @Override
        public RecommendationResult[] newArray(int size) {
            return new RecommendationResult[size];
        }
    };
}
