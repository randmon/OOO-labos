package passwordApp.ui;
import passwordApp.domain.UserDB;

import java.util.*;

public class UI {

    // An application to add passwords to a user database.
    public static void main(String[] args) {
        UserDB db = new UserDB();

        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        while (true) {
            System.out.println("Type username to add a password (* = stop)");
            username = scanner.nextLine();
            if (username.equals("*")) break;

            //Check if user exists
            if (username.isBlank() || !db.userExists(username)) {
                System.out.println("Error: User not found!");
            } else {
                System.out.println("New password:");
                password = scanner.nextLine();
                try {
                    db.addPassword(username, password);
                    System.out.println("New password successfully added.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
	    scanner.close();

	    System.out.println("Passwords per user:\n" + db.getPasswords());
        System.out.println("Ordered passwords from longest to shortest:\n"+ db.getPasswordsLongestToShortest());
    }
}
