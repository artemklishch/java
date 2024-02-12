import model.Square;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(10);
        Square square2 = new Square(20);

        System.out.println(square1.compareTo(square2));
    }
}