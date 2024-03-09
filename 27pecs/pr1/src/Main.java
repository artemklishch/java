import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("Hello", "World", "Generics");
        List<Integer> integers = List.of(10, 20, 30);
        List<Object> objects = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();

        printCollection(strings);
        printCollection(integers);
        printCollection(objects);
        printCollection(animals);
        printCollection(cats);
    }

    //    public static <T> void printCollection(Collection<T> collection) {
//        for (Object element : collection) {
//            System.out.println(element);
//        }
//    }
//    public static void printCollection(Collection<?> collection) { // ? - Wildcard
//        for (Object element : collection) {
//            System.out.println(element);
//        }
//    }

    public static <T> void printCollection(Collection<? extends Animal> collection) { // ? - Wildcard
        for (Object element : collection) {
            System.out.println(element);
        }
    }
}