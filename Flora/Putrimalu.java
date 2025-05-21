package Flora;

public class Putrimalu {
    public static String nama; // atribut nama flora
    public static String habitat; // atribut habitat flora
    public static String manfaat; // atribut manfaat flora

    public Putrimalu(String nama, String habitat, String manfaat) { // Konstruktor untuk menginisialisasi objek Putrimalu dengan nama, habitat, dan manfaat.
        this.nama = nama; 
        this.habitat = habitat; 
        this.manfaat = manfaat; 
    }

    public String getNama() { // Metode untuk mendapatkan nama tumbuhan.
        return nama; 
    }

    public String getHabitat() { // Metode untuk mendapatkan habitat tumbuhan.
        return habitat; 
    }

    public String getManfaat() { // Metode untuk mendapatkan manfaat tumbuhan.
        return manfaat; 
    }

    public static void tampilkanInfo() { // Metode statis untuk menampilkan informasi tentang tumbuhan.
        System.out.println("Nama Tumbuhan: " + nama); 
        System.out.println("Habitat: " + habitat); 
        System.out.println("Manfaat: " + manfaat); 
        System.out.println("---------------------------");
    }
}