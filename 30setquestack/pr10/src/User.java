public class User {
    private String name;
    private int age;

    public User(java.lang.String name, int age) {
        this.name = name;
        this.age = age;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        User user = (User) object;
        return age == user.age && java.util.Objects.equals(name, user.name);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, age);
    }
}
