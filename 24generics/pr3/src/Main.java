//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Box<Cloneable> boxClonble = new Box<>();
        Box<Integer> boxInteger = new Box<>();
//        Box<int> boxInt = new Box<>(); // not works
//        Box<boxInteger> boxInt = new Box<>(); // not works
        Box<Season> season = new Box<>();
    }

    enum Season {
        WINTER,
        SPRING,
        SUMMER,
        OUTOMN
    }
}