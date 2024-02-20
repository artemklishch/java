import java.lang.Cloneable;

public class Address implements Cloneable {
    private String address;

    public void setAddress(String value) {
        this.address = value;
    }

    @Override
    public String toString() {
        return address;
    }

    @Override // this is for deep clonning
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't clone address", e);
        }
    }
}
