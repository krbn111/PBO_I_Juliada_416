import java.util.Scanner;

class Mahasiswa extends User{
    String nama;
    String nim;

    Mahasiswa(String nama, String nim){
       super(nama, nim);

       this.nama = nama;
       this.nim = nim;
    }

    @Override
    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nama Mahasiswa: ");
        String Nama = input.nextLine();
        System.out.print("Masukkan Nim Mahasiswa: ");
        String Nim = input.nextLine();

        if(Nama.equals(nama) && Nim.equals(nim)){
            displayInfo();
        }else{
            System.out.println("Nama dan Nim Mahasiswa salah!");
        }

    }

    @Override
    public void displayInfo(){
        User user1 = new User("Julianda Wardojo", "202410370110416");
        System.out.println("login mahasiswa Berhasil!");
        System.out.println();
        user1.displayInfo();
    }
}