import java.util.ArrayList;

public class Passwords{
    private static ArrayList<String> passwords = new ArrayList<String>();

    public static void addAddress(String password) {
        passwords.add(password);
    }

    public static ArrayList<String> getPasswords() {
        return passwords;
    }
}
