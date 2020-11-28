import java.util.ArrayList;

public class Address{
    private static ArrayList<String> addresses = new ArrayList<String>();

    public static void addAddress(String address) {
        addresses.add(address);
    }

    public static ArrayList<String> getAddresses() {
        return addresses;
    }
}