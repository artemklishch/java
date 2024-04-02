package org.example;


import db.Storage;
import service.TruckService;

public class Main {
    public static void main(String[] args) {
        TruckService truckService = new TruckServiceImpl();
        truckService.getEngineModels(Storage.getTrucks()).forEach(System.out::println);
        truckService.getWheelMakers(Storage.getTrucks()).forEach(System.out::println);
    }
}