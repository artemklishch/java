import java.lang.Cloneable;

public class User implements Cloneable {
    private String name;
    private String lastName;
    private Address address;

    public void setName(String value) {
        this.name = value;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }

    public void setAddress(Address value) {
        this.address = value;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public User clone() {
        try {
//            return (User) super.clone(); // weak copying
            User clonedUser = (User) super.clone();
            clonedUser.setAddress(address.clone()); // deep cloning, we also have to have overriden 'clone' method in Address class
            return clonedUser;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create user", e);
        }
    }

    @Override
    public String toString() {
        return "User: "
                + "name - " + name
                + "; lastname - " + lastName
                + "; address - " + address;
    }
}
