package ui;
import domain.User;
import java.util.*;

public class WachtwoordApp1 {
    public static void main(String[] args) {
        //Array with 5 users
        User[] users_a = {new User("u1234567"), new User("u7654321"), new User("u1122334"), new User("u1212123"), new User("u4443332")};
        List<User> users = Arrays.stream(users_a).toList();

        //Collection with users and their respective passwords
        Map<User, Set<String>> passwords = new HashMap<>();
        users.forEach(x -> passwords.put(x, new HashSet<>()));

        //Add passwords to users
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username (* = stop):");
        String userName = scanner.nextLine();
        while (!userName.equals("*")) {
            //Check if user exists
            int userIndex = users.indexOf(new User(userName));
            if (userIndex == -1)
            System.out.println("User not found!");
	        else {
                User current = users.get(userIndex);
                System.out.println("New password:");
                String password = scanner.nextLine();

                //Check if password already exists for the user
                if (!passwords.get(current).contains(password)) {
                    passwords.get(current).add(password);
                    System.out.println("New password successfully added.");
                } else {
                    System.out.println("Error: password already exists for this user!");
                }
            }

            System.out.println("Username (* = stop):");
            userName = scanner.nextLine();
        }
	    scanner.close();

	    System.out.println("Passwords per user:\n" + passwords);
        TreeSet<String> orderedPasswords = new TreeSet<>((o1, o2) -> {
            int result = o2.length() - o1.length();
            if (result != 0) return result;
            return o1.compareTo(o2);
        });
        passwords.keySet().forEach(p -> orderedPasswords.addAll(passwords.get(p)));
        System.out.println("Ordered passwords from longest to shortest:\n"+ orderedPasswords);
    }
}
