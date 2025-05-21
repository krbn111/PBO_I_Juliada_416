package Modul5.Organization;

import java.util.ArrayList;
import java.util.Scanner;

import Modul5.Action.AdminActions;
import Modul5.Main.Item;
import Modul5.Main.LoginSystem;

public class Admin extends User implements AdminActions {
    static LoginSystem loginSystem = new LoginSystem();

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus angka!");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> manageItems();
                case 2 -> manageUsers();
                case 0 -> loginSystem.startLoginProcess();
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Kelola Laporan Barang ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus angka!");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> lihatSemuaLaporan();
                case 2 -> tandaiBarangClaimed(scanner);
                case 0 -> System.out.println("Kembali ke menu admin...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }

    private void lihatSemuaLaporan() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println(">> Belum ada laporan barang.");
        } else {
            System.out.println("\n=== Semua Laporan Barang ===");
            int count = 1;
            for (Item item : LoginSystem.reportedItems) {
                System.out.println(count++ + ". Barang: " + item.getNama());
                System.out.println("   Deskripsi: " + item.getDeskripsi());
                System.out.println("   Lokasi: " + item.getLokasi());
                System.out.println("   Status: " + item.getStatus());
            }
        }
    }

    private void tandaiBarangClaimed(Scanner scanner) {
        ArrayList<Item> reported = new ArrayList<>();
        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                reported.add(item);
            }
        }

        if (reported.isEmpty()) {
            System.out.println(">> Tidak ada barang berstatus 'Reported'.");
            return;
        }

        System.out.println("\n=== Daftar Barang Belum Diambil ===");
        for (int i = 0; i < reported.size(); i++) {
            Item item = reported.get(i);
            System.out.println((i + 1) + ". Barang: " + item.getNama());
            System.out.println("   Deskripsi: " + item.getDeskripsi());
            System.out.println("   Lokasi: " + item.getLokasi());
        }

        System.out.print("Masukkan nomor barang yang ingin ditandai 'Claimed': ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index > reported.size()) {
                throw new IndexOutOfBoundsException("Tidak valid");
            }

            Item selectedItem = reported.get(index);
            selectedItem.setStatus("Claimed");
            System.out.println(">> Status barang berhasil diubah menjadi 'Claimed'.");
        } catch (NumberFormatException e) {
            System.out.println(">> Input harus berupa angka.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}