import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Queue
        Queue<String> buyers = new LinkedList<>();
        buyers.add("Bob");
        buyers.add("Alice");
        buyers.add("John");
        buyers.add("Bill");
        System.out.println(buyers);

        System.out.println("OFFER");
        buyers.offer("Bruce");
        System.out.println(buyers);

        // offer відорізняєьтся від add тим, що можна використовувати, коли встановлено обмеження щодо довжини,
        // а коли довжина встановлена, помилка не викидується,
        // якщо нам птрібно прокидувати помилку при виході за межі масиву, то використувуємо метод add

        System.out.println("PEEK");
        System.out.println(buyers.peek()); // повертає перший елемент без зміни массиву
        System.out.println(buyers);

        System.out.println("POLL");
        System.out.println(buyers.poll()); // вирізає та повертає перший елемент
//        System.out.println(buyers.poll());
//        System.out.println(buyers.poll());
//        System.out.println(buyers.poll());
//        System.out.println(buyers.poll());
        System.out.println(buyers);

    }
}