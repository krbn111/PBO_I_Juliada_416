package praktikum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    private static List<String> laporan = new ArrayList<>();

    public Mahasiswa(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus angka!");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> reportItem();
                case 2 -> viewReportedItems();
                case 0 -> System.out.println("Logout...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        laporan.add("Barang: " + nama + ", Deskripsi: " + deskripsi + ", Lokasi: " + lokasi);
        System.out.println(">> Barang berhasil dilaporkan.");
    }

    @Override
    public void viewReportedItems() {
        if (laporan.isEmpty()) {
            System.out.println(">> Belum ada laporan.");
        } else {
            System.out.println("\n=== Daftar Laporan Barang ===");
            for (int i = 0; i < laporan.size(); i++) {
                System.out.println((i + 1) + ". " + laporan.get(i));
            }
        }
    }
}