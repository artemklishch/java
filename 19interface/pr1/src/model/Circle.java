package model;

public class Circle implements Figure {
    private int radius;

    public Circle(int radous) {
        this.radius = radous;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
