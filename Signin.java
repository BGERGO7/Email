import java.util.Scanner;

public class Signin {
    public static void signIn(){
        System.out.println("Email address");
        Scanner sc = new Scanner(System.in);
        String newEmail = sc.next();

        Address.addAddress(newEmail);

        System.out.println("Password");
        String newPassword = sc.next();
        Passwords.addAddress(newPassword);
        Welcome.Choice();
    }
}
