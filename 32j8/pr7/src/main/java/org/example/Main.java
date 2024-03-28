package org.example;

public class Main {
    public static void main(String[] args) {
        Test test = new Test() {
            @java.lang.Override
            public void print(java.lang.String value) {
                System.out.println(value);
            }
        };
        Test test2 = System.out::println;
        test2.print("Hello"); // method reference

        UserService userService = user -> user.getName();
        UserService userService2 = User::getName;
        UserService userService3 = (UserService) user -> {
            if (user == null) {
                return null;
            }
            return user.getName();
        };

        User bob = new User("Bob", 23);
        System.out.println(userService2.doAction(bob));
    }
}