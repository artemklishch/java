//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address.setAddress("Shevchenka");

        User user = new User();
        user.setName("Bob");
        user.setLastName("Dilan");
        user.setAddress(address);

        System.out.println(user);
        User user2 = user.clone();
        user.getAddress().setAddress("Popova");
//        System.out.println(address);
        System.out.println(user2);
        System.out.println(user);
    }
}