public class Student extends Person {
    private String favoriteSubject;

    public Student(int age, String name, String favoriteSubject) {
        super(age, name);
        this.favoriteSubject = favoriteSubject;
    }


    public String getFavoriteSubject() {
        return favoriteSubject;
    }
    public void setFavoriteSubject(String value){
        this.favoriteSubject = value;
    }

    @Override
    public String getPersonalInfo(){
        return "i am student " + getName();
    }

    @Override
    public String sayHello() {
        return null;
    }

}
