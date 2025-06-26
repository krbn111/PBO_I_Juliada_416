package main.modul6.Organization;
import java.util.ArrayList;

//import com.example.praktikum.Model.Item;

public abstract class User {
    
    private String Username;
    private String Password;
    protected static ArrayList<User> Userlist = new ArrayList<>();

    static {
        User.Userlist.add(new Mahasiswa("Julianda","202410370110416"));
        User.Userlist.add(new Mahasiswa("Mohan","123456789"));
        User.Userlist.add(new Mahasiswa("Bile","202410370110417"));
        User.Userlist.add(new Admin("Admin","Admin123"));
        Userlist.add(new Admin("1234","1234"));
    }

    public User(String username,String password) {
        Username = username;
        Password = password;
    }
    public User(){

    }

    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }

    public static ArrayList<User> getUserlist() {
        return Userlist;
    }

    public static void setUserlist(ArrayList<User> userlist) {
        Userlist = userlist;
    }

    public abstract boolean inputCheck(String Username, String Password);
    public abstract void DisplayAppMenu();

    @Override
    public String toString(){
        return 
        "========Data User==========\n"
        +"Akses     : " + this.getClass().getSimpleName() + "\n"
        +"Username  : " + this.Username + "\n"
        +"Password  : " + this.Password + "\n";

    }
}
