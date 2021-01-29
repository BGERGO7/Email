import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static HashMap<String, String> addressesAndPasswords = new HashMap<String,String>();

    public static void main(String[] args) {
        Choice();
    }

    public static void Choice() {
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        
        Scanner choiceScanner = new Scanner(System.in);
        int choice = choiceScanner.nextInt();

        try {
            if (choice == 1) {
                // Log in
            } else if (choice == 2) {
                // Sign up
                Sign_up();
            } else {
                // Wrong number
                System.out.println("Wrong number");
                WrongChoice();
            }
        } catch (Exception e) {
            // Not a number
            System.out.println("Not a number");
            WrongChoice();
        }

    }

    // If wrong number or not a number
    static void WrongChoice() {
        Choice();
    }

    static void Sign_up(){
        System.out.println("email address");

        Scanner signUpScanner = new Scanner(System.in);
        String inputAddress = signUpScanner.nextLine();
        //If Hashmap contains the address
        if(addressesAndPasswords.containsKey(inputAddress) == false){
            //HashMap does not contains address
            
            
            String address = inputAddress;

            System.out.println("password");
            String inputPassword = signUpScanner.nextLine();
            
            //If HashMap contains password
            if(addressesAndPasswords.containsValue(inputPassword) == false){
                //HashMap does not contains password

                String password = inputPassword;

                addressesAndPasswords.put(address, password);
                System.out.println(addressesAndPasswords);
                Choice();
            }else if(addressesAndPasswords.containsValue(inputPassword) == true){
                //HashMap contains password

                WrongSign_up();
            }
        }else if(addressesAndPasswords.containsKey(inputAddress) == true){
            //HashMap contains address
            WrongSign_up();
        }
    }

    static void WrongSign_up(){
        Sign_up();
    }

}
