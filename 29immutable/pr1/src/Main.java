import java.util.ArrayList;
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
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Ukrainian");

        Address address = new Address("Shevchenko", 26);

        User user1 = new User("Bob", "Alison", 23, address, languages);
        userFavoriteSubjects.put(user1, List.of("Math", "Chemistry"));

        System.out.println(userFavoriteSubjects.get(user1));
        System.out.println(user1.getLanguages());
//        user1.getLanguages().add("Italian");
        languages.add("Italian");
        System.out.println(userFavoriteSubjects.get(user1));
    }
}