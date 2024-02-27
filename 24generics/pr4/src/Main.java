//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(1, "hello");
        Integer key = pair.getKey(); // 1
        String value = pair.getValue(); // "hello"

        Pair<Integer, String> secondPair = new Pair<>(1, "hello");
        boolean mustBeTrue = pair.equals(secondPair); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == secondPair.hashCode(); // true!

        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);

        Pair<Object, Object> firstPair1 = new Pair<>(null, null);
        Pair<Object, Object> secondPair1 = new Pair<>(null, null);
        boolean actualResult = firstPair1.equals(secondPair);
        System.out.println(actualResult);
    }
}