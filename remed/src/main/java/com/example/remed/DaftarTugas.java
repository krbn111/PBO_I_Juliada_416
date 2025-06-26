package com.example.remed;

import java.util.ArrayList;

public class DaftarTugas {
    private ArrayList<Tugas> daftarTugas = new ArrayList<>();

    public void tambahTugas(Tugas tugas) {
        daftarTugas.add(tugas);
    }

    public void hapusTugas(int index) throws Exception {
        if (index < 0 || index >= daftarTugas.size())
            throw new Exception("Index tidak valid.");
        if (!daftarTugas.get(index).isSelesai())
            throw new Exception("Tugas belum selesai, tidak bisa dihapus.");
        daftarTugas.remove(index);
    }

    public void tandaiSelesai(int index) throws Exception {
        if (index < 0 || index >= daftarTugas.size())
            throw new Exception("Index tidak valid.");
        if (daftarTugas.get(index).isSelesai())
            throw new Exception("Tugas sudah selesai.");
        daftarTugas.get(index).setSelesai(true);
    }

    public ArrayList<Tugas> getDaftarTugas() {
        return daftarTugas;
    }
}
