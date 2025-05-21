import java.util.Scanner;

public class LoginSystem{
    public static void main(String [] args){
        Admin admin1 = new Admin("admin", "admin123");
        Mahasiswa mahasiswa1 = new Mahasiswa("Julianda Wardojo", "202410370110416");
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih login(1/2): ");
        int login = input.nextInt();

        if(login == 1){
            admin1.login();
        }else if(login == 2){
            mahasiswa1.login();
        }else {
            System.out.println("Data tidak Valid!");
        }

    }
}