package org.example;

import model.Car;
import model.User;
import service.AdvertisementService;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // There is a list of advertisements
        // Return the Map<User, List<Car>>
        // where key is a user that creates the advertisements
        // and value is a List of cars manufactured after 2015

        AdvertisementService advertisementService = new AdvertisementServiceimpl();
        Map<User, List<Car>> allYearGreaterThan = advertisementService.getAllYearGreaterThan(2015);
        allYearGreaterThan.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}