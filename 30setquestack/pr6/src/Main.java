import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Stack
        // останній елемент, який ми отримуємо в колекцію - вийде першим
        // stack це класс, не інтерфейс, тому при створенні стеку ми використовуємо його як конструктор,
        // а не використовуємо якийсь інший клас для створення сутності, як наприклад, у випадку з Queue

        Stack<String> plates = new Stack<>();
        plates.add("plate 1");
        plates.add("plate 2");
        plates.add("plate 3");
        plates.add("plate 4");
        plates.add("plate 5");
        plates.push("plate 6");
        System.out.println(plates);
        // push == add
        // але якщо ми хочемо додати едемент по індексу, то використовуємо метод add

//        System.out.println(plates.peek());
//        System.out.println(plates.peek());
//        System.out.println(plates.peek());
        System.out.println(plates.pop());
        System.out.println(plates.pop());
        System.out.println(plates.pop());
        System.out.println(plates);
    }
}