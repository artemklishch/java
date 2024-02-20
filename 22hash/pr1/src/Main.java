//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Bob", 30, "1234");
        User user2 = new User("Bob", 30, "1234");
        User user3 = new User("Alice", 23, "2222");
//        User user2 = new SuperUser("Bob", 30, "1234");
        System.out.println(user1.equals(user2));

        int hashCode = user1.hashCode();
        System.out.println(hashCode);

        // 1. if two objects are equal - they must have the same hash code
        // 2. if two objects have the same hash code - they may be or may not be equal
        // 3. if two objects have different hash code - they must be not equal
        // 4. the same object should return the same hash code until any of the properties are modified

        // First case
        System.out.println("First case");
        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

        // Second case

        // Third case
        System.out.println("Third case");
        System.out.println(user3.equals(user2));
        System.out.println(user3.hashCode());
        System.out.println(user2.hashCode());
    }
}