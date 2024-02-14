package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource(); MyResource resource1 = new MyResource()) { // this works only if expression is autocloseable !
            System.out.println("Try with resourc");
        }
    }
}