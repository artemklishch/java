public class User {
    public static String name;
    public int age;

    @Override
    public String toString() {
        age = 30;
        name = "John";
        return name;
    }

    public static void access() {
        name = "Bobby";
//        this.age = 21; impossible
    }
}
