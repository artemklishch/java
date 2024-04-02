package org.example;

import db.Storage;
import model.Advertisement;
import model.Car;
import model.User;
import service.AdvertisementService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvertisementServiceimpl implements AdvertisementService {
    @java.lang.Override
    public Map<User, List<Car>> getAllYearGreaterThan(int year) {
        return Storage.getAdvertisements().stream()
                .filter(a -> a.getCar().getYear() >= year)
                .collect(Collectors.groupingBy(
                        Advertisement::getOwner, // key of the Map
                        Collectors.mapping(
                                Advertisement::getCar, // objects we are going to group argument
                                Collectors.toList() // the entity to which we are going to group the first argument
                        )
                ));
    }
}
