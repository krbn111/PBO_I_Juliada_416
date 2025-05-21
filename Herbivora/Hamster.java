package Herbivora;

public class Hamster extends Hewan implements Herbivora { //// 'Hamster' adalah subclass dari 'Hewan' dan mengimplementasikan interface 'Herbivora'

    public Hamster(String nama, int umur) {
        super(nama, umur);
    }

    @Override
    public void suara() { // Implementasi metode abstrak dari Hewan
        System.out.println("Suara: Cicit-cicit!");
    }

    @Override
    public void bergerak() { // Implementasi metode abstrak dari Hewan
        System.out.println("Bergerak: Hamster berlari di roda.");
    }

    @Override
    public void jenisMakanan() { // Implementasi metode abstrak dari Herbivora
        System.out.println("Makanan: biji-bijian.");
    }
}
