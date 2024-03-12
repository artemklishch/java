import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Collisions
//        Rectangle rec1 = new Rectangle(10, 20);
//        Map<Rectangle, Integer> recIntegerMap1 = new HashMap<>();
//        recIntegerMap1.put(rec1, 100);
//        System.out.println(recIntegerMap1);
//
//        Rectangle rec2 = new Rectangle(10, 20);
//        System.out.println(recIntegerMap1.get(rec2));
        Rectangle rec1 = new Rectangle(10, 20);
        Rectangle rec2 = new Rectangle(15, 15);
        Rectangle rec3 = new Rectangle(4, 10);
        Rectangle rec4 = new Rectangle(15, 15);
        Map<Rectangle, Integer> map1 = new HashMap<>();
        map1.put(rec1, 100);
        map1.put(rec2, 200);
        map1.put(rec3, 250);
        map1.put(rec4, 700);
        System.out.println(map1.get(rec1));
        System.out.println(map1.get(rec2));
        System.out.println(map1.get(rec3));
        System.out.println(map1.get(rec4));
    }
}