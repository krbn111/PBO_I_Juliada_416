package praktikum;

import java.util.Scanner;

public class Admin extends User implements AdminActions {

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
                case 0 -> System.out.println("Logout...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (choice != 0);
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}
