package org.example.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity(name = "electric_car")
public class ElectricCar extends Machine{
    private double chargeLevel;

    public ElectricCar() {
    }

    public ElectricCar(String name, BigDecimal price, double chargeLevel) {
        super(name, price);
        this.chargeLevel = chargeLevel;
    }

    public double getChargeLevel() {
        return chargeLevel;
    }

    public void setChargeLevel(double chargeLevel) {
        this.chargeLevel = chargeLevel;
    }
}
