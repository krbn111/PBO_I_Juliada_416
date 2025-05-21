package Modul5.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Modul5.Organization.Admin;
import Modul5.Organization.Mahasiswa;
import Modul5.Organization.User;

public class LoginSystem {

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    static {
        userList.add(new Admin("admin", "admin123"));
        userList.add(new Mahasiswa("Julianda", "202410370110416"));
        userList.add(new Mahasiswa("Budi", "202410370110417"));
        userList.add(new Admin("root", "superpass"));
    }

    public void startLoginProcess() {
        Scanner scanner = new Scanner(System.in);
        int roleChoice = -1;

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Mahasiswa");
        System.out.println("2. Login sebagai Admin");

        while (true) {
            System.out.print("Pilih peran (1/2): ");
            if (scanner.hasNextInt()) {
                try {
                    roleChoice = scanner.nextInt();
                    
                } catch (InputMismatchException Exception) {
                    System.out.println(Exception.getMessage());
                }
                scanner.nextLine(); 
                if (roleChoice == 1 || roleChoice == 2) break;
                else System.out.println(">> Pilihan hanya 1 atau 2.");
            } else {
                System.out.println(">> Input harus berupa angka.");
                scanner.next(); 
            }
        }

        System.out.print("Username/Nama Mahasiswa: ");
        String inputUser = scanner.nextLine();
        System.out.print("Password/NIM: ");
        String inputPass = scanner.nextLine();

        User currentUser = verifyLogin(inputUser, inputPass, roleChoice);

        if (currentUser != null) {
            currentUser.displayAppMenu();
        } else {
            System.out.println("Login gagal. Data tidak ditemukan atau salah.");
        }
    }

    private User verifyLogin(String inputUser, String inputPass, int roleChoice) {
        for (User user : userList) {
            if (roleChoice == 2 && user instanceof Admin admin) {
                if (admin.getUsername().equals(inputUser) && admin.getPassword().equals(inputPass)) {
                    return admin;
                }
            } else if (roleChoice == 1 && user instanceof Mahasiswa mhs) {
                if (mhs.getUsername().equalsIgnoreCase(inputUser) && mhs.getPassword().equals(inputPass)) {
                    return mhs;
                }
            }
        }
        return null;
    }
}
