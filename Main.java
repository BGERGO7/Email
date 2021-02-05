import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> sentMessage = new ArrayList<String>();

    public static HashMap<String, String> addressesAndPasswords = new HashMap<String,String>();

    public static HashMap<String, ArrayList<String>> messages = new HashMap<String, ArrayList<String>>();

    public static String address;

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
                Log_in();
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

    static void Log_in(){
        System.out.println("Email address");

        Scanner logInScanner = new Scanner(System.in);
        String inputAddress = logInScanner.nextLine();
        //If HashMap does not contain adderss
        if(addressesAndPasswords.containsKey(inputAddress) == false){
            WrongLog_in();

            //else
        }else if(addressesAndPasswords.containsKey(inputAddress) == true){
            //Ask the password
            address = inputAddress;
            System.out.println("Password");
            String inputPassword = logInScanner.nextLine();

            //Wrong password
            if(addressesAndPasswords.containsValue(inputPassword) == false){
                WrongLog_in();

                //else
            }else if(addressesAndPasswords.containsValue(inputPassword) == true){
                //System
                System();
            }
        }

    }

    static void WrongLog_in(){
        Log_in();
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

    static void System(){
        //Checking unread messages
        if(messages.containsKey(address) == false){
            System.out.println("You haven`t got unread emails");
        }else if(messages.containsKey(address) == true){
            System.out.println("You have got unread messages");
            //Show unread messages
            System.out.println(messages.get(address));
        }

        //Write emails or Exit
        System.out.println("1.Write");
        System.out.println("2.Exit");
        System.out.println("3. All messages");

        Scanner systemScanner = new Scanner(System.in);
        int input = systemScanner.nextInt();

        try {
            if (input == 1) {
                //Write
                Write();
            } else if (input == 2) {
                //Exit
                Choice();
            }
            else {
                // Wrong number
                System.out.println("Wrong number");
                System();
            }
        } catch (Exception e) {
            // Not a number
            System.out.println("Not a number");
            System();
        }

    }

    static void Write(){
        System.out.println("Email address to write");
        Scanner writeScanner = new Scanner(System.in);
        String addressToWrite = writeScanner.nextLine();

        //Check if address exsits
        if(addressesAndPasswords.containsKey(addressToWrite) == false){
            System.out.println("Address does not exist");
            Write();
        }else if(addressesAndPasswords.containsKey(addressToWrite) == true){
            System.out.println("The message:");
            String message = writeScanner.nextLine();
            sentMessage.add(message);
            messages.put(addressToWrite, sentMessage);
            Choice();
        }
    }

}
