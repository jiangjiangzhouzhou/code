package com.jiang.code;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.extern.java.Log;

@Log
@Getter
@Setter
public class Order {
    private ArrayList<String> orders = new ArrayList<>();

    //Get order from input
    public void getOrders() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your order and press # to stop");
        String newString;
        while (sc.hasNextInt()) {
            newString = sc.nextLine();
            int number = Integer.parseInt(newString.replaceAll("[^0-9]", ""));
            if (number < 0) {
                throw new IllegalArgumentException("The number of items must be bigger than 0.");
            } else {
                if (newString.equals("#")) {
                    sc.close();
                } else {
                    orders.add(newString);
                }
            }
        }
    }

    //get order number for different media type.
    public int getMediaNumber(String code) {
        String order;
        int number = -1;
        if (orders.isEmpty()){
            throw new IllegalArgumentException("There is no order");
        }
        else {
            for (String s : orders) {
                order = s;
                if (order.contains(code)) {
                    number = Integer.parseInt(order.replaceAll("[^0-9]", ""));
                }
            }
        }
        if (number < 0){
            throw new IllegalArgumentException("There is no order for $code type");
        }
        return number;
    }

    //Print out the result using log of lombok
    public void printResult(Post post, int[] bundles, int number) {
        double cost = 0;
        for (int i = 0; i < post.getPrices().length; i++) {
            cost = post.getPrices()[i] * bundles[i] + cost;
        }
        log.info(number + " " + post.getFormatCode() + " $" + cost);
        for (int f = 0; f < post.getBundles().length; f++) {
            if (bundles[f] != 0) {
                log.info(bundles[f] + " * " + post.getBundles()[f] + " $" + post.getPrices()[f] * bundles[f]);
            }
        }
    }
}
