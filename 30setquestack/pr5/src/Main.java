import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Deque
        Deque<String> clients = new LinkedList<>();
        clients.add("Bob");
        clients.add("Alice");
        clients.add("John");
        System.out.println(clients);

//        System.out.println(clients.pollFirst());
//        System.out.println(clients.pollLast());
        System.out.println(clients.removeLast());
        System.out.println(clients);
        // removeLast - якщо колекція буде пуста ми отримаємо помилку,
        // pollLast - помилки немає при пустій колекції, а повертає null
    }
}