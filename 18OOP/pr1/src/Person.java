public abstract class Person {
    private int age;
    private String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return  age;
    }
    public void setAge(int value){
        this.age = value;
    }

    public String getName(){
        return  name;
    }
    public  void setName(String value){
        this.name = value;
    }
    public String getPersonalInfo(){
        return  "Age: " + age + ". Name: " + name;
    }

    public abstract String sayHello();
}
