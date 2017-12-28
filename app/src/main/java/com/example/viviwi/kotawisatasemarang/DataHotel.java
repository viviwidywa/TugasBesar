package com.example.viviwi.kotawisatasemarang;

/**
 * Created by Michael Antony on 12/19/2017.
 */

public class DataHotel {
    String nama, info, lokasi, koordinat,nomor,website,gambarutama;

    public DataHotel(String nama, String info, String lokasi, String koordinat, String nomor,String website, String gambarutama) {
        this.nama = nama;
        this.info = info;
        this.lokasi = lokasi;
        this.koordinat = koordinat;
        this.nomor = nomor;
        this.website=website;
        this.gambarutama = gambarutama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKoordinat() {
        return koordinat;
    }

    public void setKoordinat(String koordinat) {
        this.koordinat = koordinat;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGambarutama() {
        return gambarutama;
    }

    public void setGambarutama(String gambarutama) {
        this.gambarutama = gambarutama;
    }
}
