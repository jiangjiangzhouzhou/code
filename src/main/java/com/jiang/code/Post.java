package com.jiang.code;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Post {
    private String submissionFormat;
    private String formatCode;
    private int[] bundles;
    private double[] prices;

    public Post(String format, String code, int[] bundle, double[] price) {
        submissionFormat = format;
        formatCode = code;
        bundles = bundle;
        prices = price;
    }
}
