import model.Horse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String mail = "Hello, mail";
        Box boxMail = new Box(mail);

        Horse horse = new Horse("Pony");
        Box horseBox = new Box(boxMail);

//        Box<Horse> newHorseBox = new Box<Horse>(mail);
        Box<Horse> newHorseBox = new Box<Horse>(horse);
        Horse value = newHorseBox.getValue();

        Box<String> newMailBox = new Box<>(mail);
        String value1 = newMailBox.getValue();

//        Object horseValue = horseBox.getValue();
//        Horse horseValue = (Horse) horseBox.getValue();
//        System.out.println(horseValue.getName());
    }
}