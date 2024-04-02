package model;

public class Car {
    private String maker;
    private String model;
    private int year;

    public Car(java.lang.String maker, java.lang.String model, int year) {
        this.maker = maker;
        this.model = model;
        this.year = year;
    }

    public java.lang.String getMaker() {
        return maker;
    }

    public java.lang.String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Car{" +
                "maker=" + maker +
                ", model=" + model +
                ", year=" + year +
                '}';
    }
}
