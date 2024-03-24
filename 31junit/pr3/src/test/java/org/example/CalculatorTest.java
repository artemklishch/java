package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void division_Ok() {
        int a = 10;
        int b = 20;
        double actual = calculator.calculate(a, b, "/");
        double expected = 0.5;
        assertEquals(expected, actual);
    }
}