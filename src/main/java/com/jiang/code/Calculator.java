package com.jiang.code;

public class Calculator {

    //calculate bundle breakdown for each submission format based on the order
    public int[] calculate(int amount, int[] formats) {
        int[] bundleNumbers = new int[formats.length];
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
}
