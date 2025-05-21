public class User {
    private String Name;
    private String Nim;

    public User(String Name, String Nim) {
        this.Name = Name;
        this.Nim = Nim;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setNim(String nim) {
        Nim = nim;
    }

    public String getNim() {
        return Nim;
    }

    public void login() {
        System.out.println("Login");
    }

    public void displayInfo() {
        
        System.out.println("Informasi Pengguna: ");
        System.out.println("Nama: " + getName());
        System.out.println("Nim: " + getNim());
    }
}