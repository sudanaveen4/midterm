import java.util.HashMap;
import java.util.Map;

public class Login {

    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("ram", "3025");
    }

    public static boolean login(String username, String ID) {
        String expectedID = users.get(username);
        return expectedID != null && expectedID.equals(ID);
    }

    public static void main(String[] args) {
        String username = "suda";
        String ID = "sudatheking";

        boolean loggedIn = login(username, ID);

        if (loggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }
    }
}