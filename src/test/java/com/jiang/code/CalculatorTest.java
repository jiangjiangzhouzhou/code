package com.jiang.code;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator tester = new Calculator();
    int[] testResult = {1, 1};
    int[] imgBundles = {5, 10};
    double[] imgPrices = {450, 800};
    Post imgFormat = new Post("IMG", imgBundles, imgPrices);

    //test calculate function
    @Test
    void testCalculate() {
        assertArrayEquals(testResult, tester.calculate(11, imgFormat.getBundles()));
    }
}