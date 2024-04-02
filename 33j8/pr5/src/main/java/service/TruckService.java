package service;

import model.Truck;

import java.util.List;

public interface TruckService {
    List<String> getEngineModels(List<Truck> trucks);

    List<String> getWheelMakers(List<Truck> trucks);
}
