//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Bob", 22);
        User user2 = User.of("Alice", 25);

        System.out.println(user1);
        System.out.println(user2);
    }
}