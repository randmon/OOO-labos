package ui;
import domain.UserDB;

import java.util.*;

public class UI {

    public static void main(String[] args) {
        UserDB db = new UserDB();

        //Add passwords to users
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username (* = stop):");
        String username = scanner.nextLine();
        while (!username.equals("*")) {
            //Check if user exists
            if (!db.userExists(username)) {
                System.out.println("User not found!");
            } else {
                System.out.println("New password:");
                String password = scanner.nextLine();
                if (db.addPassword(username, password)) {
                    System.out.println("New password successfully added.");
                } else {
                    System.out.println("Error: password already exists for this user!");
                }
            }
            System.out.println("Username (* = stop):");
            username = scanner.nextLine();
        }
	    scanner.close();

	    System.out.println("Passwords per user:\n" + db.getPasswords());
        System.out.println("Ordered passwords from longest to shortest:\n"+ db.getPasswordsLongestToShortest());
    }
}
