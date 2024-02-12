public class Cat extends Animal {
    static {
        System.out.println("Cat static block");
    }

    {
        System.out.println("Cat no static block");
    }

    public Cat(String name) {
        super(name);
        System.out.println("Cat constructor");
    }
}
