import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertationInTheEnd {
    public void start(int size) {
        insertToArrayLiat(size);
        System.out.println();
        insertToLinkedList(size);
    }

    private void insertToArrayLiat(int size) {
        List<Integer> arrayList = new ArrayList<>();
        System.out.println("Starting insertation to the end of array list...");
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long end = System.nanoTime();

        System.out.println("Insertation to the end of array list completed");
        System.out.println("Took: " + ((end - start) / 1000000) + "ms");
    }

    private void insertToLinkedList(int size) {
        List<Integer> linkedList = new LinkedList<>();
        System.out.println("Starting insertation to the end of linked list...");
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        long end = System.nanoTime();

        System.out.println("Insertation to the end of linked list completed");
        System.out.println("Took: " + ((end - start) / 1000000) + "ms");
    }
}
