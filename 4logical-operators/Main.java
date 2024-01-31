public class Main {
    public static void main(String[] args) {
        int age = 17;
        // int age = 18;
        // boolean hasAccess = age >= 18;
        // boolean hasAccess = age < 18;
        // boolean hasAccess = age == 18;
        // boolean hasAccess = age != 18;
        boolean hasAccess = age < 18;
        System.out.println(hasAccess);

        // if (hasAccess) {
        // System.out.println("Access granted");
        // } else {
        // System.out.println("Access denied");
        // }
        if (!hasAccess) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}