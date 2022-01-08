package com.jiang.code;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] imgBundles = {5, 10};
        double[] imgPrices = {450, 800};
        int[] audBundles = {3, 6, 9};
        double[] audPrices = {427.5, 810, 1147.50};
        int[] vidBundles = {3, 5, 9};
        double[] vidPrices = {570, 900, 1530};

        Post img = new Post("IMG", imgBundles, imgPrices);
        Post aud = new Post("Flac", audBundles, audPrices);
        Post vid = new Post("VID", vidBundles, vidPrices);
        Order newOrder = new Order();
        newOrder.getOrders();
        Calculator newCalculator = new Calculator();
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(img);
        posts.add(aud);
        posts.add(vid);
        for (Post p : posts) {
            int number = newOrder.getMediaNumber(p.getFormatCode());
            int[] result = newCalculator.calculate(number, p.getBundles());
            p.printPost(result, number);
        }
    }
}
