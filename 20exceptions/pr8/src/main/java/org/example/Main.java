package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws UserNotFoundException {
        UserService userService = new UserService();
        String[] records = {"john@gmail.com:78", "rick@yahoo.com:99",
                "greg@gmail.com:20", "russell@mail.us:141", "jerry@mail.us:0", "mortimer@mail.us:53",
                "test@gmail.com:2", "bob@mail.com:141986"};
        System.out.println(userService.getUserScore(records, "bob@mail.com"));
    }
}