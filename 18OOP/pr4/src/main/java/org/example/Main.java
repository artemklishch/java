package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        System.out.println(printer.print("12344", 22));

        String[] strings = {"aaa", "bbb", "ccc"};

        System.out.println(printer.print(strings));
    }
}