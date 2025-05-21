package praktikum;

import java.util.Scanner;

public class LoginSystem {
    public void startLoginProcess() {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("admin", "admin123");
        Mahasiswa mhs = new Mahasiswa("Julianda", "202410370110416");

        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        User currentUser = null;

        if (admin.login(user, pass)) {
            currentUser = admin;
        } else if (mhs.login(user, pass)) {
            currentUser = mhs;
        } else {
            System.out.println("Login gagal. Username atau password salah.");
            return;
        }

        currentUser.displayAppMenu();
    }
}