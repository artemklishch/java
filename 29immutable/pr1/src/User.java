import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class User {
    private String name;
    private String lastname;
    private int age;
    private Address address;
    private List<String> languages;

    public User(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public User(String name, String lastname, int age, Address address, List<String> languages) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getLanguages() {
        return new ArrayList<>(languages);
    }
}
