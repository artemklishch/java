public class Animal {
    public static String STATIC_FIELD = "abc";
    private String name;

    static {
        STATIC_FIELD = "cbd";
        System.out.println("Animal static block");
    }

    {
        name = "Mary";
        STATIC_FIELD = "bcd";
        System.out.println("Animal no static block");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor");
    }
}
