package org.example;

import java.util.NoSuchElementException;
import java.util.Optional;

public class GetOptionalValue {
  public Integer getOptionalValue(int randomNumber) {
    Optional<Integer> optional = generateRandomOptional(randomNumber);
    return optional.orElseThrow(() -> new NoSuchElementException("Empty"));
  }

  public Optional<Integer> generateRandomOptional(int randomNumber) {
    return randomNumber % 2 != 0 ? Optional.of(randomNumber) : Optional.empty();
  }
}
