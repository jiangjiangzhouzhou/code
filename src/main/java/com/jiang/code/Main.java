package com.jiang.code;

public class Main {
    public static void main(String[] args) {
        int[] imgBundles = {5, 10};
        double[] imgPrices = {450, 800};
        int[] audBundles = {3, 6, 9};
        double[] audPrices = {427.5, 810, 1147.50};
        int[] vidBundles = {3, 5, 9};
        double[] vidPrices = {570, 900, 1530};
        Format imgFormat = new Format("IMG", imgBundles, imgPrices);
        Format audFormat = new Format("Flac", audBundles, audPrices);
        Format vidFormat = new Format("VID", vidBundles, vidPrices);
        Order newOrder = new Order();
        Calculator newCalculator = new Calculator();
        newOrder.getOrder(imgFormat.getFormatCode(), audFormat.getFormatCode(), vidFormat.getFormatCode());
        int[] imgResult = newCalculator.calculate(newOrder.getImgNumber(), imgFormat.getBundles());
        int[] audResult = newCalculator.calculate(newOrder.getAudioNumber(), audFormat.getBundles());
        int[] vidResult = newCalculator.calculate(newOrder.getVideoNumber(), vidFormat.getBundles());
        newCalculator.printResult(imgFormat.getPrices(), imgResult, newOrder.getImgNumber(), imgFormat.getFormatCode(), imgFormat.getBundles());
        newCalculator.printResult(audFormat.getPrices(), audResult, newOrder.getAudioNumber(), audFormat.getFormatCode(), audFormat.getBundles());
        newCalculator.printResult(vidFormat.getPrices(), vidResult, newOrder.getVideoNumber(), vidFormat.getFormatCode(), vidFormat.getBundles());
    }
}
