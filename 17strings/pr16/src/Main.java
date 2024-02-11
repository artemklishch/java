public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Object o = new Object();
        System.out.println(o);

        int ageBob = 18;
        int ageAlice = 18;
//        Integer size = new Integer(200);
        Integer sizeBox = Integer.valueOf(200);
        Integer sizeProduct = Integer.valueOf(200);
        System.out.println(ageBob == ageAlice);
        System.out.println(sizeBox == sizeProduct);
        System.out.println(sizeBox.equals(sizeProduct));

        Integer age1 = 20;

        print(ageBob);
        print(age1);

        String hello = "Hello!";
        String helloMessage = "Hello!";
    }

    public static void print(int value){
        System.out.println("priont value: " + value);
    }
}