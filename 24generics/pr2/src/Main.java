import model.Cat;
import model.Horse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Horse horse = new Horse("Pony");

        Aviary<Cat> catsAviary = new Aviary<>(cat);
        Aviary<Horse> horseAviary = new Aviary<>(horse);

        Cat animal1 = catsAviary.getAnimal();

        String message = "Hello world";
//        Aviary<String> dogAviary = new Aviary<>(message);

        catsAviary.feed("Meat");
    }
}