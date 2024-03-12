public class User {
    private String name;
    private String lastname;
    private int age;

    public User(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return age == user.age && java.util.Objects.equals(name, user.name) && java.util.Objects.equals(lastname, user.lastname);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, lastname, age);
    }

//    public int hashCode() {
//        return age;
//    }


    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "name=" + name +
                ", lastname=" + lastname +
                ", age=" + age +
                '}';
    }
}
