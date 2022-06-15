package domain;

import java.util.*;

public class UserDB {
    private final List<User> users;
    private final Map<User, Set<String>> passwords;

    public UserDB() {
        //Default list with 5 users
        User[] defaults = {new User("u1234567"), new User("u7654321"), new User("u1122334"), new User("u1212123"), new User("u4443332")};
        users = Arrays.stream(defaults).toList();
        //Collection with users and their respective passwords
        passwords = new HashMap<>();
        users.forEach(x -> passwords.put(x, new HashSet<>()));
    }

    public boolean userExists(String username) {
        return users.contains(new User(username));
    }

    public void addPassword (String username, String password) {
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password cannot be empty!");
        User u = getUserByName(username);
        boolean added = passwords.get(u).add(password);
        if (!added) throw new IllegalArgumentException("Password already exists for this user!");
    }

    public String getPasswords() {
        return String.valueOf(passwords);
    }

    public String getPasswordsLongestToShortest() {
        TreeSet<String> orderedPasswords = new TreeSet<>((o1, o2) -> {
            int result = o2.length() - o1.length();
            if (result != 0) return result;
            return o1.compareTo(o2);
        });
        passwords.keySet().forEach(p -> orderedPasswords.addAll(passwords.get(p)));
        return String.valueOf(orderedPasswords);
    }

    private User getUserByName(String username) throws IllegalArgumentException {
        for (User u : users) {
            if (u.username().equals(username)) return u;
        }
        throw new IllegalArgumentException("User \"" + username + "\" doesn't exist!");
    }
}
