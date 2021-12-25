package com.jiang.code;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator tester = new Calculator();
    int[] testResult = {0, 1};
    int[] imgBundles = {5, 10};
    double[] imgPrices = {450, 800};
    Format imgFormat = new Format("IMG", imgBundles, imgPrices);

    @Test
    void testExceptionIsThrown() {
        Calculator tester = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> tester.calculate(-10, imgFormat.getBundles()));
    }

    //test calculate function
    @Test
    void testCalculate() {
        assertEquals(testResult, tester.calculate(10, imgFormat.getBundles()));
    }
}