package com.rumahsakit;

import java.util.LinkedList;
import java.util.Queue;

public class AntrianRS {
    private Queue<Pasien> antrian = new LinkedList<>();
    private int nomorTerakhir = 0;

    public void tambahPasien(String nama, String keluhan) {
        nomorTerakhir++;
        antrian.add(new Pasien(nama, keluhan, nomorTerakhir));
    }

    public Queue<Pasien> getAntrian() {
        return antrian;
    }

    public Pasien panggilPasien() {
        return antrian.poll();
    }

    public void reset() {
        antrian.clear();
        nomorTerakhir = 0;
    }
}
