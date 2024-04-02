package org.example;

import model.Truck;
import model.Wheel;
import service.TruckService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TruckServiceImpl implements TruckService {
    @Override
    public List<String> getEngineModels(List<Truck> trucks) {
        return trucks
                .stream()
                .map(t -> t.getEngine().getModel())// get engine models list
                .distinct() // get unique values
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getWheelMakers(List<Truck> trucks) {
        return trucks
                .stream()
                .map(Truck::getWheels)
                .flatMap(Collection::stream)// extract nested subarrays
                .map(Wheel::getMaker)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
