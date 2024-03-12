import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    private static final Map<User, List<String>> usersFavoriteSubjects = new HashMap<>();

    public static void main(String[] args) {
        // performance
        User bob = new User("Bob", "Alisin", 10);
        User alice = new User("Alice", "Jackson", 26);
        User john = new User("John", "Johnson", 42);
        User bill = new User("Bill", "Swanson", 58);

//        Map<User, List<String>> usersFavoriteSubjects = new HashMap<>();
        usersFavoriteSubjects.put(bob, List.of("Math", "Chemistry"));
        usersFavoriteSubjects.put(alice, List.of("Math", "Physics"));
        usersFavoriteSubjects.put(john, List.of("Biology", "Chemistry"));
        usersFavoriteSubjects.put(bill, List.of("Art", "Music"));

//        System.out.println(usersFavoriteSubjects.get(bob));
//        System.out.println(usersFavoriteSubjects.get(alice));
//        System.out.println(usersFavoriteSubjects.get(john));
//        System.out.println(usersFavoriteSubjects.get(bill));

        System.out.println(getFavoriteSubjects("Bob"));
        System.out.println(getUsersbySubject("Math"));

        for (Map.Entry<User, List<String>> entry : usersFavoriteSubjects.entrySet()) {
            System.out.println("User " + entry.getKey().getName() + " subjects " + entry.getValue());
        }
    }

    private static List<String> getFavoriteSubjects(String username) {
        for (Map.Entry<User, List<String>> entry : usersFavoriteSubjects.entrySet()) {
            if (entry.getKey().getName().equals(username)) {
                return entry.getValue();
            }
        }
        return Collections.emptyList();
    }

    private static List<User> getUsersbySubject(String subject) {
        List<User> users = new ArrayList<>();
        for (Map.Entry<User, List<String>> entry : usersFavoriteSubjects.entrySet()) {
            if (entry.getValue().contains(subject)) {
                users.add(entry.getKey());
            }
        }
        return users;
    }
}