package Flora; 

import Flora.*; // Mengimpor semua kelas dari paket Flora.

public class MainPutrimalu { // Mendefinisikan kelas MainPutrimalu.
    public static void main(String[] args) { // Memulai metode main, titik masuk program.
        Putrimalu putrimalu = new Putrimalu("Putri Malu", "Hutan Tropis", "meredakan batuk dan membersihkan lendir dari saluran pernapasan."); 
        // Membuat objek Putrimalu dengan nama, habitat, dan manfaat.
        Putrimalu.tampilkanInfo(); // Memanggil metode statis tampilkanInfo untuk menampilkan informasi tentang tumbuhan.
    }
}