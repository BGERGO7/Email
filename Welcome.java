import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        System.out.println("Welcome to our E-mail system!");
        System.out.println("Press 1 if you want to log in");
        System.out.println("Press 2 if you want to sign in");
        Choice();
    }

    public static void Choice() {
        Scanner scanner = new Scanner(System.in);

        int logOrSign = scanner.nextInt();

        if(logOrSign == 1){
            //Log
            scanner.close();
            Login.login();
        }else if(logOrSign == 2){
            //Sign
            scanner.close();
            Signin.signIn();
        }else{
            //ujra
            WrongChoice();
        }
    }

    public static void WrongChoice() {
        System.out.println("Please try again!");

        Choice();
    }
}
