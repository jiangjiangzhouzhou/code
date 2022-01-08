package com.jiang.code;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Setter
@Getter

public class Post {
    private String formatCode;
    private int[] bundles;
    private double[] prices;

    public Post(String code, int[] bundle, double[] price) {
        formatCode = code;
        bundles = bundle;
        prices = price;
    }

    //Print out the result using log of lombok
    public void printPost(int[] bundles, int number) {
        double cost = 0;
        for (int i = 0; i < prices.length; i++) {
            cost = prices[i] * bundles[i] + cost;
        }
        log.info(number + " " + formatCode + " $" + cost);
        for (int f = 0; f < bundles.length; f++) {
            if (bundles[f] != 0) {
                log.info(bundles[f] + " * " + bundles[f] + " $" + prices[f] * bundles[f]);
            }
        }
    }
}
