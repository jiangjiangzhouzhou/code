package com.jiang.code;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] imgBundles = {5, 10};
        Double[] imgPrices = {450.0, 800.0};
        int[] audBundles = {3, 6, 9};
        Double[] audPrices = {427.5, 810.0, 1147.50};
        int[] vidBundles = {3, 5, 9};
        Double[] vidPrices = {570.0, 900.0, 1530.0};

        Post img = new Post("IMG", imgBundles, imgPrices);
        Post aud = new Post("Flac", audBundles, audPrices);
        Post vid = new Post("VID", vidBundles, vidPrices);
        Receiver receiver = new Receiver();
        receiver.receiveInputs();
        Analyser analyser = new Analyser();
        Printer printer = new Printer();
        Calculator newCalculator = new Calculator();
        List<Post> posts = new ArrayList<>();
        posts.add(img);
        posts.add(aud);
        posts.add(vid);
        Order newOrder = new Order();
        newOrder.setOrders(analyser.getMediaNumber(receiver.getInputs()));
        posts.forEach(p ->{
            int[] result = newCalculator.calculate(newOrder.getOrderNUmber(p.getFormatCode()), p.getBundles());
            printer.printPost(p,result, newOrder.getOrderNUmber(p.getFormatCode()));
        });
    }
}
