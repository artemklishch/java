import model.Animal;

public class Aviary<T extends Animal & Cloneable> {
    private T animal;

    public Aviary(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public void feed(String food){

    }
}
