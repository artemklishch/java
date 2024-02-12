//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        sayHello(); // static method can be invoked in the class
//        noStatic(); // impossible to call no static method like this - only via object
        Main obj = new Main();
        obj.noStatic();

        User user1 = new User();
        User user2 = new User();

//        user1.name ="Bob";
        User.name = "Bob";
        System.out.println(user1);
        System.out.println(user2);

        Animal animal = new Cat("Cat");
//        String someVal = Animal.STATIC_FIELD;
    }

    public static void sayHello() {
        System.out.println("Hello");
    }

    public void noStatic() {
        sayHello(); // static method can be invoked in the no static method
        System.out.println("I am not static");
    }
}