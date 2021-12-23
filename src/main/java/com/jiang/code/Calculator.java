package com.jiang.code;


public class Calculator {
    public static void main(String[] args) {
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

    }
}
