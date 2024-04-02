package service;

import model.Car;
import model.User;

import java.util.Map;
import java.util.List;

public interface AdvertisementService {
    Map<User, List<Car>> getAllYearGreaterThan(int year);
}
