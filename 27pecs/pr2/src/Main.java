import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        List<Integer> myInts = new ArrayList<Integer>();

        // Invariance
//        List<Number> myNums = myInts; // this is doesn't work
//        Cat cat = new Cat();
//        Animal animal = cat;

        // Covariance
        List<? extends Number> numbers1 = new ArrayList<Integer>();
        List<? extends Number> numbers2 = new ArrayList<Double>();
        List<? extends Number> numbers3 = new ArrayList<Float>();

        List<Cat> cats = new ArrayList<>();
//        List<Animal> animals = cats; //not working
        List<? extends Animal> animals = cats;

        // Contravariance
        List<? super Number> numbers4 = new ArrayList<>();
        numbers4.add(Integer.valueOf(10));
        numbers4.add(Double.valueOf(10.15));
        numbers4.add(Float.valueOf(10.15f));
//        numbers4.add(new Object()); // not working
    }
}