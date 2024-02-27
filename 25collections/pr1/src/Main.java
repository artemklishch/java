import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(1, 15);
        list1.remove(2);
        list1.set(2, 100);
        list1.remove(Integer.valueOf(100));

        System.out.println(list1.get(0));

        System.out.println(list1.size());

        System.out.println(list1);
    }
}