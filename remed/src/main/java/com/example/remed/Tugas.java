package com.example.remed;

public class Tugas {
    private String judul;
    private String modul;
    private boolean selesai;

    public Tugas(String judul, String modul) {
        this.judul = judul;
        this.modul = modul;
        this.selesai = false;
    }

    public String getJudul() { return judul; }
    public String getModul() { return modul; }
    public boolean isSelesai() { return selesai; }

    public void setSelesai(boolean selesai) { this.selesai = selesai; }

    @Override
    public String toString() {
        return judul + " (Modul " + modul + ") " + (selesai ? "[SELESAI]" : "");
    }
}

