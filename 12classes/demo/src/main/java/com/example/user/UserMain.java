package com.example.user;

public class UserMain {
    public static void main(String[] args) {
        AdultUser user1 = new AdultUser();
        // user1.age = 19; // the field is private
        user1.setAge(19);
        int user1Age = user1.getAge();
        System.out.println(user1Age);
    }
}
