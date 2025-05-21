package CD4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();

        // Tambah data awal
        daftarBarang.add(new Barang("Pensil", 100));
        daftarBarang.add(new Barang("Buku", 50));
        daftarBarang.add(new Barang("Penghapus", 30));

        Scanner scanner = new Scanner(System.in);
        int pilihan = -1;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Bersihkan newline
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.next(); // clear invalid input
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();

                    int stokAwal;
                    try {
                        System.out.print("Masukkan stok awal: ");
                        stokAwal = scanner.nextInt();
                        scanner.nextLine();
                        daftarBarang.add(new Barang(nama, stokAwal));
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Stok harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("Daftar Barang:");
                        for (Barang b : daftarBarang) {
                            System.out.println("Nama: " + b.getNama() + ", Stok: " + b.getStok());
                        }
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang yang tersedia.");
                        break;
                    }

                    System.out.println("Daftar Barang:");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                    }

                    try {
                        System.out.print("Masukkan nomor indeks barang: ");
                        int indeks = scanner.nextInt();

                        System.out.print("Masukkan jumlah stok yang akan dikurangi: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        Barang b = daftarBarang.get(indeks);
                        if (jumlah > b.getStok()) {
                            throw new StokTidakCukupException("Stok " + b.getNama() + " hanya tersisa " + b.getStok());
                        }

                        b.setStok(b.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid.");
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Opsi tidak valid.");
            }

        } while (pilihan != 0);

        scanner.close();
    }
}
