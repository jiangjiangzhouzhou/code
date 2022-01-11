package com.jiang.code;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.stream.IntStream;


public class Calculator {
    private int previousNumber = 0;
    private int currentNumber;
    private int count = 0;
    private int origin = 0;
    private int[] format;
    private int[] temResult;// store the temporary result
    @Setter
    @Getter
    private int[] result;//The result of the calculation

    public int[] calculate(int amount, int[] formats) {
        int[] bundleNumbers = new int[formats.length];
        int[] bundleNumber = new int[formats.length];
        Arrays.fill(bundleNumbers, 0);
        Arrays.fill(bundleNumber, 0);
        result = bundleNumber;
        temResult = bundleNumbers;
        count = formats.length - 1;
        format = formats;
        origin = amount;
        previousNumber = 0;//initialize after last calculation
        currentNumber = 0;//initialize after last calculation
        int smallBundle = amount / formats[formats.length - 1] + 1;
        int bigBundle = amount / formats[0] + 1;
        if (amount % formats[formats.length - 1] == 0) {
            result[formats.length - 1] = amount / formats[formats.length - 1];
            return result;
        }
        if (amount != 0) {
            IntStream.range(smallBundle, bigBundle + 1).forEach(i -> getLoop(i, 0, 0));
        }
        return result;
    }

    public void getLoop(int maxNumber, int bundle, int p) {
        if (p < count) {
            IntStream.range(0, maxNumber + 1).forEach(i -> {
                temResult[p] = i;
                int countBundle = i * format[p] + bundle;
                int pos = p + 1;
                getLoop(maxNumber - i, countBundle, pos);
            });
        }
        currentNumber = bundle + maxNumber * format[p];
        temResult[p] = maxNumber;
        if ((previousNumber == 0 && currentNumber >= origin) || (currentNumber >= origin && currentNumber < previousNumber)) {
            previousNumber = currentNumber;
            IntStream.range(0, temResult.length).forEach(i -> result[i] = temResult[i]);
        }
    }
}
