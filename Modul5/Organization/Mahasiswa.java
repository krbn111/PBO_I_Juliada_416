package Modul5.Organization;

import java.util.Scanner;

import Modul5.Action.MahasiswaActions;
import Modul5.Main.Item;
import Modul5.Main.LoginSystem;

public class Mahasiswa extends User implements MahasiswaActions {
    static LoginSystem loginSystem = new LoginSystem();

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
                case 0 -> loginSystem.startLoginProcess();
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

        Item newItem = new Item(nama, deskripsi, lokasi);
        LoginSystem.reportedItems.add(newItem);

        System.out.println(">> Barang berhasil dilaporkan.");
    }

    @Override
    public void viewReportedItems() {
        boolean ada = false;
        System.out.println("\n=== Daftar Laporan Barang (Reported) ===");
        int count = 1;
        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                System.out.println(count++ + ". Barang: " + item.getNama());
                System.out.println("   Deskripsi: " + item.getDeskripsi());
                System.out.println("   Lokasi: " + item.getLokasi());
                ada = true;
            }
        }

        if (!ada) {
            System.out.println(">> Belum ada laporan barang.");
        }
    }
}