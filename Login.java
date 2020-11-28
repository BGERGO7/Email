import java.util.Scanner;

public class Login {
    public static void login() {
        System.out.println("Email address:");
        Scanner sc = new Scanner(System.in);
        String addressInput = sc.next();
        boolean isSuccessful = false;

        for (String x : Address.getAddresses()) {
            if (x == addressInput) {
                isSuccessful = true;
            }
        }

        if (isSuccessful == true) {
            sc.close();
            password();
        } else {
            worngAddress();
        }
    }

    public static void worngAddress() {
        System.out.println("Wrong address. Please try again");
        login();
    }
    public static void wrongPassword() {
        System.out.println("Wrong password. Please try again");
        password();
    }

    public static void password(){
         boolean isSuccessful = false;
         System.out.println("Password:");
         Scanner sc = new Scanner(System.in);
         String passwordInput = sc.next();
         for(String x : Passwords.getPasswords()){
             if(x == passwordInput){
                 isSuccessful = true;
             }
         }

         if(isSuccessful == true){
            //Go to main
            sc.close();
         }else{
            wrongPassword();
         }
    }
}
