import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> addresses = new ArrayList<String>();
    private static ArrayList<String> passwords = new ArrayList<String>();

    public static void addAddress(String address) {
        addresses.add(address);
    }

    public static ArrayList<String> getAddresses() {
        return addresses;
    }

    public static void addPassword(String password) {
        passwords.add(password);
    }

    public static ArrayList<String> getPasswords() {
        return passwords;
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to our E-mail system!");
        LoginOrSignIn();
    }

    public static void LoginOrSignIn(){
        System.out.println("Press 1 if you want to log in");
        System.out.println("Press 2 if you want to sign in");
        
        int choice = sc.nextInt();

        if(choice == 1){
            sc.nextLine();
            Login();
        }else if(choice == 2){
            sc.nextLine();
            SingIn();
        }else{
            WrongChoice();
        }
    }

    public static void WrongChoice(){
        LoginOrSignIn();
    }

    public static void Login(){
        System.out.println("E-mail address");
        String email = sc.nextLine();

        if(addresses.contains(email)){
            System.out.println("Password");
            String password = sc.nextLine();
            if(passwords.contains(password)){
                System.out.println("Logged in successfully");
            }else{
                System.out.println("Wrong password");
                Login();
            }
        }else{
            System.out.println("Wrong email address");
            Login();
        }
    }

    public static void SingIn(){
        System.out.println("Please add a new E-mail address");
        String newEmailAddress = sc.nextLine();
        if(addresses.contains(newEmailAddress)){
            System.out.println("There is an address called:" + newEmailAddress+ " . Please add a new one");
            SingIn();
        }
        addresses.add(newEmailAddress);
        System.out.println("Please add a new password");
        String newPassword = sc.nextLine();
        passwords.add(newPassword);
        System.out.println(getAddresses());
        System.out.println(getPasswords());
        LoginOrSignIn();
    }
}
