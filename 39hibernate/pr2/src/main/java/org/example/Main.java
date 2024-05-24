package org.example;

import org.example.dao.CarDao;
import org.example.dao.CarDaoImpl;
import org.example.model.Car;

public class Main {
    public static void main(String[] args) {
        CarDao carDao = new CarDaoImpl();
        System.out.println(carDao.get(1L));

        Car bmw = new Car();
        bmw.setModel("X1");
        bmw.setYear(2019);
        Car bmwUpdated = carDao.save(bmw);
        System.out.println(bmwUpdated);
    }
}