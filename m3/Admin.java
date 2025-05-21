import java.util.Scanner;

class Admin extends User{
    String username;
    String password;
    Scanner input = new Scanner(System.in);

    Admin(String username, String password){
        super(username, password);
        this.username = username;
        this.password = password;
    }

    @Override
    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Username: ");
        String Username = input.nextLine();
        System.out.print("Masukkan Password: ");
        String Password = input.nextLine();

        if(Username.equals(username) && Password.equals(password)){
            displayInfo();
        }else{
            System.out.println("Username dan Password yang anda masukkan salah!");
        }
    }

    @Override
    public void displayInfo(){
        System.out.println("Login Admin Berhasil");
    }
}