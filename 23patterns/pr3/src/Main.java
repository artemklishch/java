//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Car redAudi = new Car("audi", "red");
//        Car audy1999 = new Car("audi", 1999);

        Car redAudi = new Car.Builder().setColor("red").setModel("audi").build();
        System.out.println(redAudi);
    }
}