import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        String message = "Hello world";
//        String upperCase = message.toUpperCase();
//        System.out.println(message);
//        System.out.println(upperCase);
        Map<User, List<String>> userFavoriteSubjects = new HashMap<>();
        User user1 = new User("Bob", "Alison", 23);
        userFavoriteSubjects.put(user1, List.of("Math", "Chemistry"));

        System.out.println(userFavoriteSubjects.get(user1));

        user1.setAddress(new Address("Shevchenko", 26));
        System.out.println(userFavoriteSubjects.get(user1));

        System.out.println("==========");

        Map<String, String> capitals = new HashMap<>();
        String ukraine = "Ukraine";
        capitals.put(ukraine, "Kyiv");
        System.out.println(capitals.get(ukraine));
        ukraine.toUpperCase();
        System.out.println(capitals.get(ukraine));
    }
}