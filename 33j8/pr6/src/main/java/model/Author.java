package model;

public class Author {
    private String name;
    private String lastname;

    public Author(java.lang.String name, java.lang.String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getLastname() {
        return lastname;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Author{" +
                "name=" + name +
                ", lastname=" + lastname +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Author author = (Author) object;
        return java.util.Objects.equals(name, author.name) && java.util.Objects.equals(lastname, author.lastname);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, lastname);
    }
}
