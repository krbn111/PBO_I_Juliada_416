package com.rumahsakit;

public class Pasien {
    private String nama;
    private String keluhan;
    private int nomorAntrian;

    public Pasien(String nama, String keluhan, int nomorAntrian) {
        this.nama = nama;
        this.keluhan = keluhan;
        this.nomorAntrian = nomorAntrian;
    }

    public String toString() {
        return "No." + nomorAntrian + " - " + nama + " | Keluhan: " + keluhan;
    }
}
