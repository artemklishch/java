public class Main {
    public static void main(String[] args) {
        String name = "Bob";
        // String name = new String("Bob");
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        chars[0] = 'b';
        String newName = new String(chars);
        System.out.println(newName);

        System.out.println("-----");

        String upperCaseName = newName.toUpperCase();
        System.out.println(upperCaseName);

        String name1 = "AlicE";
        String lowerCaseName = name1.toLowerCase();
        System.out.println(lowerCaseName);
    }

}