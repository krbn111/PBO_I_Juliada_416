package Herbivora;

public abstract class Hewan {
    private String nama;
    private int umur;

    public Hewan(String nama, int umur) { // Konstruktor untuk menginisialisasi nama dan umur
        this.nama = nama;
        this.umur = umur;
    }

    public abstract void suara(); // Metode abstrak, harus diimplementasikan di subclass
    public abstract void bergerak();

    public void info() { // Metode konkret untuk menampilkan info hewan
        System.out.println("Nama: " + nama);
        System.out.println("Umur: " + umur + " bulan");
    }
}
