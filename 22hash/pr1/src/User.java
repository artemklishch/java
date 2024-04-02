import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String inn;

    public User(String name, int age, String inn) {
        this.name = name;
        this.age = age;
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int value) {
        this.age = value;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String value) {
        this.inn = value;
    }

    @Override
    public boolean equals(Object user) {
        // reflection
        if (user == this) {
            return true;
        }
        // null check
        if (user == null) {
            return false;
        }
        // symmetric: if a.equals(b) is true, b.equals(a) must be true
        // transitive: if a.equals(b) is true and b.equals(c) is true, c.equals(a) must be true
        // consistent: multiple invocations of equals() must return the same
//        if (user.getClass().equals(User.class)) { // it doesn't work for cases when one class inherits another class
//            User current = (User) user;
//            return this.name.equals(current.name) && this.age == current.age && this.inn.equals(current.inn);
//        }
//        if (user instanceof User) { // it works for cases when one class inherits another class
//            User current = (User) user;
//            return this.name.equals(current.name) && this.age == current.age && this.inn.equals(current.inn);
//        }
        if (user.getClass().equals(User.class)) { // it works for cases when one class inherits another class
            User current = (User) user;
            return Objects.equals(this.name, current.name)
                    && this.age == current.age
                    && Objects.equals(this.inn, current.inn);
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + age;
        result = 31 * result + (inn == null ? 0 : inn.hashCode());
        return result;
//        return 5;
    }
}
