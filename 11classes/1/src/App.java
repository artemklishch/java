import model.User;

public class App {
    public static void main(String[] args) throws Exception {
        User bobUser = new User();
        bobUser.age = 24;
        bobUser.name = "Bob";
        bobUser.favoriteTopic = "IT";

        User aliceUser = new User();
        aliceUser.age = 23;
        aliceUser.name = "Alice";
        aliceUser.favoriteTopic = "Fantasy";

        User[] users = { bobUser, aliceUser };

        for (User user : users) {
            System.out.println("user " + user.name);
        }

    }
}
