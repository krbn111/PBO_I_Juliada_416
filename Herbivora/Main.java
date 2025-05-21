package Herbivora;

public class Main {
    public static void main(String[] args) {
        Hamster hamster = new Hamster("Cimit", 3); // Membuat objek hamster dengan nama dan umur
        hamster.info();
        hamster.suara();
        hamster.bergerak();
        hamster.jenisMakanan();
    }
}
