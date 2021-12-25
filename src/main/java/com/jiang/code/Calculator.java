package com.jiang.code;

import lombok.extern.java.Log;

import java.util.Scanner;

@Log
public class Calculator {

    //calculate bundle breakdown for each submission format based on the order
    public int[] calculate(int amount, int[] formats) {
        int[] bundleNumbers = new int[formats.length];
        if (amount <= 0) {
            throw new IllegalArgumentException("The number of items must be bigger than 0");
        }
        int previousNumber = 0;
        int currentNumber;
        int smallBundle = amount / formats[formats.length - 1] + 1;
        int bigBundle = amount / formats[0] + 1;
        if (amount % formats[formats.length - 1] == 0) {
            for (int i = 0; i < formats.length - 1; i++) {
                bundleNumbers[i] = 0;
            }
            bundleNumbers[formats.length - 1] = amount / formats[formats.length - 1];
        } else {
            for (int i = smallBundle; i <= bigBundle; i++) {
                for (int a = 0; a <= i; a++) {
                    if (formats.length == 3) {
                        for (int b = 0; b <= i - a; b++) {
                            currentNumber = a * formats[0] + b * formats[1] + (i - a - b) * formats[2];
                            if (previousNumber == 0 || (currentNumber >= amount && currentNumber < previousNumber)) {
                                previousNumber = currentNumber;
                                bundleNumbers[0] = a;
                                bundleNumbers[1] = b;
                                bundleNumbers[2] = i - a - b;
                            }
                        }
                    } else {
                        currentNumber = a * formats[0] + (i - a) * formats[1];
                        if (previousNumber == 0 || (currentNumber >= amount && currentNumber < previousNumber)) {
                            previousNumber = currentNumber;
                            bundleNumbers[0] = a;
                            bundleNumbers[1] = i - a;
                        }
                    }
                }
            }
        }
        return bundleNumbers;
    }

    //Print out the result using log of lombok
    public void printResult(double[] prices, int[] bundles, int number, String label, int[] format) {
        double cost = 0;
        for (int i = 0; i < prices.length; i++) {
            cost = prices[i] * bundles[i] + cost;
        }
        log.info(number + " " + label + " $" + cost);
        for (int f = 0; f < format.length; f++) {
            if (bundles[f] != 0) {
                log.info(bundles[f] + " * " + format[f] + " $" + prices[f] * bundles[f]);
            }
        }
    }
}
