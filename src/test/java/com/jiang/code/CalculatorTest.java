package com.jiang.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void testGetCalculate() {
        Calculator tester = new Calculator();
        int[] testResult = {1, 1};
        int[] testBundle = {5, 10};
        assertArrayEquals(testResult, tester.calculate(11, testBundle));
    }
}