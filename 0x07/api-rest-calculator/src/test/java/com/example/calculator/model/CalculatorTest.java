package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setup() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        Assertions.assertEquals(calculator.sum(1d,2d), 3);
    }

    @Test
    public void numbersNullSumTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.sum(null,2d));
    }

    @Test
    void subTest() {
        Assertions.assertEquals(calculator.sub(3d, 1d), 2);
    }

    @Test
    void divideTest() {
        Assertions.assertEquals(calculator.divide(3d, 1d), 3);
    }

    @Test
    public void divisionByZeroTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(5d,0d));
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(calculator.factorial(3), 6);
    }

    @Test
    void integerToBinaryTest() {
        Assertions.assertEquals(calculator.integerToBinary(5), 101);
    }

    @Test
    void integerToHexadecimalTest() {
        Assertions.assertEquals(calculator.integerToHexadecimal(170), "aa");
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate date1 = LocalDate.of(2020, 3, 15);
        LocalDate date2 = LocalDate.of(2020, 3, 29);
        Assertions.assertEquals(calculator.calculeDayBetweenDate(date1, date2), 14);
    }
}
