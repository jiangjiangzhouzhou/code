package com.jiang.code;

public class Main {
    public static void main(String[] args) {
        int[] imgBundles = {5, 10};
        double[] imgPrices = {450, 800};
        int[] audBundles = {3, 6, 9};
        double[] audPrices = {427.5, 810, 1147.50};
        int[] vidBundles = {3, 5, 9};
        double[] vidPrices = {570, 900, 1530};

        Post img = new Post("Image", "IMG", imgBundles, imgPrices);
        Post aud = new Post("Audio", "Flac", audBundles, audPrices);
        Post vid = new Post("Video", "VID", vidBundles, vidPrices);
        Order newOrder = new Order();
        newOrder.getOrders();
        Calculator newCalculator = new Calculator();
        int imgNumber = newOrder.getMediaNumber(img.getFormatCode());
        int audNumber = newOrder.getMediaNumber(aud.getFormatCode());
        int vidNumber = newOrder.getMediaNumber(vid.getFormatCode());
        int[] imgResult = newCalculator.calculate(imgNumber, img.getBundles());
        int[] audResult = newCalculator.calculate(audNumber, aud.getBundles());
        int[] vidResult = newCalculator.calculate(vidNumber, vid.getBundles());
        newOrder.printResult(img.getPrices(), imgResult, imgNumber, img.getFormatCode(), img.getBundles());
        newOrder.printResult(aud.getPrices(), audResult, audNumber, aud.getFormatCode(), aud.getBundles());
        newOrder.printResult(vid.getPrices(), vidResult, vidNumber, vid.getFormatCode(), vid.getBundles());
    }
}
