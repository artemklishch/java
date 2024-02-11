public class SuperStudent extends Student {
    private String lastName;
    public SuperStudent(int age, String name, String favoriteSubject, String lastName) {
        super(age, name, favoriteSubject);
        this.lastName = lastName;
    }
}
