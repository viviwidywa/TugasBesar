package com.example.viviwi.kotawisatasemarang;

import java.util.Map;

/**
 * Created by Michael Antony on 12/11/2017.
 */

public class DataWisataKuliner {
    String nama, info, lokasi, koordinat, nomor,gambarutama;
    Map<String, String> gambar;

    public DataWisataKuliner(){

    }

    public DataWisataKuliner(String nama, String info, String lokasi, String koordinat, String nomor, Map<String, String> gambar, String gambarutama) {
        this.nama = nama;
        this.info = info;
        this.lokasi = lokasi;
        this.koordinat = koordinat;
        this.nomor = nomor;
        this.gambar = gambar;
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

    public Map<String, String> getGambar() {
        return gambar;
    }

    public void setGambar(Map<String, String> gambar) {
        this.gambar = gambar;
    }

    public String getGambarutama() {
        return gambarutama;
    }

    public void setGambarutama(String gambarutama) {
        this.gambarutama = gambarutama;
    }
}
