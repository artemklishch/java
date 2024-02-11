//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person bob = new Employee(20, "Bob", 100);
//        System.out.println(bob.getSalary());

//        Student alice = new Student(23, "Alice", "Physics");
        Person alice = new Student(23, "Alice", "Physics");

//        Person john = new Person(23, "John");

//        System.out.println(bob.getPersonalInfo());
//        System.out.println(alice.getPersonalInfo());

//        Person[] persons = new Person[]{bob, alice, john};
        Person[] persons = new Person[]{bob, alice};
        for (Person person : persons) {
            printInfo(person);
        }
    }

    public static void printInfo(Person person) {
        System.out.println(person.getPersonalInfo());
    }
}