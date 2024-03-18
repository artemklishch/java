import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User bob = new User("Bob", 22);
        User alice = new User("Alice", 23);

        List<User> users = new ArrayList<>();
        users.add(bob);
        users.add(alice);

        List<User> usersCopy = getCopy(users);
        users.get(0).setAge(32);
        System.out.println(usersCopy);
    }

    private static List<User> getCopy(List<User> users) {
        List<User> usersCopy = new ArrayList<>(users.size());
        for (User user: users) {
         usersCopy.add(user.clone());
        }
        return usersCopy;
    }
}