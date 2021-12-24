package com.jiang.code;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import lombok.extern.java.Log;
@Log
public class Calculator {
    int[] imgBundles = {5,10};
    double[] imgPrices = {450, 800};
    int[] audBundles = {3,6,9};
    double[] audPrices = {427.5, 810, 1147.50};
    int[] vidBundles = {3,5,9};
    double[] vidPrices = {570, 900, 1530};
    Format imgFormat = new Format("IMG", imgBundles,imgPrices);
    Format audFormat = new Format("Flac", audBundles,audPrices);
    Format vidFormat = new Format("VID", vidBundles,vidPrices);
    Order newOrder = new Order();

    public static void main(String[] args) {
        Calculator newCalculator = new Calculator();
        newCalculator.getOrder();
        int[] imgResult = newCalculator.calculate(newCalculator.newOrder.getImgNumber(), newCalculator.imgFormat.getBundles());
        int[] audResult = newCalculator.calculate(newCalculator.newOrder.getAudioNumber(), newCalculator.audFormat.getBundles());
        int[] vidResult = newCalculator.calculate(newCalculator.newOrder.getVideoNumber(), newCalculator.vidFormat.getBundles());
        printResult(newCalculator.imgFormat.getPrices(), imgResult,newCalculator.newOrder.getImgNumber(),newCalculator.imgFormat.getFormatCode(),newCalculator.imgFormat.getBundles());
        printResult(newCalculator.audFormat.getPrices(), audResult,newCalculator.newOrder.getAudioNumber(),newCalculator.audFormat.getFormatCode(),newCalculator.audFormat.getBundles());
        printResult(newCalculator.vidFormat.getPrices(), vidResult,newCalculator.newOrder.getVideoNumber(),newCalculator.vidFormat.getFormatCode(),newCalculator.vidFormat.getBundles());
    }

    public void getOrder(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your order and press # to stop");
        while (sc.hasNextInt()){
            String newString = sc.nextLine();
            if (newString.contains(imgFormat.getFormatCode())){
                newOrder.setImgNumber(Integer.parseInt(newString.replaceAll("[^0-9]", "")));
            }
            else if (newString.contains(audFormat.getFormatCode())){
                newOrder.setAudioNumber(Integer.parseInt(newString.replaceAll("[^0-9]", "")));
            }
            else if (newString.contains(vidFormat.getFormatCode())){
                newOrder.setVideoNumber(Integer.parseInt(newString.replaceAll("[^0-9]", "")));
            }
            else if (newString.equals("#")){
                sc.close();
            }
        }
    }

    public int[] calculate(int amount, int[] formats){
        int[] bundleNumbers = new int[formats.length];
        int previousNumber = 0;
        int currentNumber;
        int smallFormat = formats[0];
        int bigFormat = Arrays.stream(formats).max().getAsInt();
        int smallBundle = amount / bigFormat+1;
        int bigBundle = amount / smallFormat +1;
        if (amount % bigFormat == 0) {
            for(int i = 0; i< formats.length-1; i++){
                bundleNumbers[i] = 0;
            }
            bundleNumbers[formats.length-1] = amount/bigFormat;
        }
        else{
            for (int i = smallBundle; i <= bigBundle; i++) {
                for (int a = 0; a <= i; a++) {
                    if (formats.length == 3) {
                        for (int b = 0; b <= i - a; b++) {
                            currentNumber = a * formats[0] + b * formats[1] + (i - a - b) * formats[2];
                            if (previousNumber == 0 || (currentNumber >= amount && currentNumber < previousNumber)) {
                                previousNumber = currentNumber;
                                bundleNumbers[0] = a;
                                bundleNumbers[1] = b;
                                bundleNumbers[2] = i-a-b;
                            }
                        }
                    }
                    else {
                        currentNumber = a * formats[0] + (i - a) * formats[1];
                        if (previousNumber == 0 || (currentNumber >= amount && currentNumber < previousNumber)) {
                            previousNumber = currentNumber;
                            bundleNumbers[0] = a;
                            bundleNumbers[1] = i-a;
                        }
                    }
                }
            }
        }
        return bundleNumbers;
    }

    public static void printResult(double[] prices, int[] bundles, int number, String label, int[] format) {
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
