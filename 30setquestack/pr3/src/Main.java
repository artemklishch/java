import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // TreeSet
        Set<Integer> numbers1 = new TreeSet<>();
        numbers1.add(10);
        numbers1.add(-10);
        numbers1.add(-50);
        numbers1.add(0);
        numbers1.add(99);
        numbers1.add(7);
        System.out.println(numbers1); // returns sorted ascending order

        Comparator<User> userComparator = new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                int nameCompared = user1.getName().compareTo(user2.getName());
                if (nameCompared != 0) {
                    return nameCompared;
                }
                return Integer.compare(user1.getAge(), user2.getAge());
            }
        };

//        Set<User> users1 = new TreeSet<>(userComparator);
        Set<User> users1 = new TreeSet<>(userComparator.reversed()); // сортування в зворотному порядку
        users1.add(new User("Bob", 23));
        users1.add(new User("Alice", 22));
        users1.add(new User("John", 27));
        users1.add(new User("Bob", 27));
        users1.add(new User("Bob", 19));
        System.out.println(users1);
    }
}