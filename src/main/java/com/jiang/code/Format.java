package com.jiang.code;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Format {
    private String formatCode;
    private int[] bundles;
    private double[] prices;

    public Format(String code, int[] bundle, double[] price) {
        formatCode = code;
        bundles = bundle;
        prices = price;
    }
}
