import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, String> addressesAndPasswords = new HashMap<String,String>();

    public static HashMap<String, ArrayList<String>> messages = new HashMap<String, ArrayList<String>>();

    public static String address;

    public static ArrayList<String> sentMessage = new ArrayList<String>();

    public static void main(String[] args) {
        Choice();
    }

    public static void Choice() {
        System.out.println("1. Log in");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        
        Scanner choiceScanner = new Scanner(System.in);
        int choice = choiceScanner.nextInt();

        try {
            if (choice == 1) {
                Log_in();
            } else if (choice == 2) {
                Sign_up();
            } else if(choice == 3){
                //Exit
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("Wrong number");
                Choice();
            }
        } catch (Exception e) {
            System.out.println("Not a number");
            Choice();
        }

    }


    static void Log_in(){
        System.out.println("Email address");
        System.out.println("2.Exit");

        Scanner logInScanner = new Scanner(System.in);
        String inputAddress = logInScanner.nextLine();
        //If input is Exit
        if(inputAddress == "2"){
          Choice();
        }

        //If HashMap does not contain adderss
        if(addressesAndPasswords.containsKey(inputAddress) == false){
            WrongLog_in();
        }else if(addressesAndPasswords.containsKey(inputAddress) == true){
            //Ask the password
            address = inputAddress;
            System.out.println("Password");
            String inputPassword = logInScanner.nextLine();

            //Wrong password
            if(addressesAndPasswords.containsValue(inputPassword) == false){
                WrongLog_in();

            }else if(addressesAndPasswords.containsValue(inputPassword) == true){
                //System
                System();
            }
        }

    }


    static void Sign_up(){
        System.out.println("Email address");
        System.out.println("2.Exit");

        Scanner signUpScanner = new Scanner(System.in);
        String inputAddress = signUpScanner.nextLine();
        //If intput is exit
        if(inputAddress == "2"){
          Choice();
        }
        
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
                Choice();
            }else if(addressesAndPasswords.containsValue(inputPassword) == true){
                //HashMap contains password
                Sign_up();
            }
        }else if(addressesAndPasswords.containsKey(inputAddress) == true){
            //HashMap contains address
            Sign_up();
        }

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
        System.out.println("2.Exit");
        Scanner writeScanner = new Scanner(System.in);
        String addressToWrite = writeScanner.nextLine();

        //If input is Exit
        if(addressToWrite == "2"){
          Choice();
        }

        //Check if address exsits
        if(addressesAndPasswords.containsKey(addressToWrite) == false){
            System.out.println("Address does not exist");
            Write();
        }else if(addressesAndPasswords.containsKey(addressToWrite) == true){
            
            //Check if the address Hashmap contains value of the address
            if(messages.containsKey(addressToWrite) == false){
              System.out.println("The message:");
              String message = writeScanner.nextLine();
              ArrayList<String> sentMessage = new ArrayList<String>();
              sentMessage.add(message);
              messages.put(addressToWrite, sentMessage);
              Choice();
            }else if(messages.containsKey(addressToWrite) == true){
              System.out.println("The message:");
              String message = writeScanner.nextLine();
              messages.get(addressToWrite).add(message);
              Choice();
            }
        }
    }
}
