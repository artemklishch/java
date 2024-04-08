package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class CarModels {
  private static int START_YEAR = 1955;

  public static List<String> getCarModels(List<Car> cars) {
    return cars.stream()
            .filter(c -> c.getYear() > START_YEAR)
            .map(Car::getModel)
            .collect(Collectors.toList());
  }
}
