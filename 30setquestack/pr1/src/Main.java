import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Bob");
        names.add("Bob");
        names.add("Bob");
        names.add("Alice");
        names.add("Alice");
        names.add("Alice");
//        System.out.println(names);

        List<String> namesList = new ArrayList<>();
        namesList.add("Bob");
//        namesList.add("Bob");
//        namesList.add("Bob");
//        namesList.add("Alice");
//        namesList.add("Alice");
//        namesList.add("Alice");
//        String l1 = namesList.get(0);
//        System.out.println(namesList);

        System.out.println(names.contains("Bob"));
        System.out.println(names.contains("Jane"));
    }
}