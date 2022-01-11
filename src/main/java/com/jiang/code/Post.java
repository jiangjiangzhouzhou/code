package com.jiang.code;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Setter
@Getter
@NonNull

public class Post {
    private String formatCode;
    private int[] bundles;
    private Double[] prices;

    public Post(String code, int[] bundle, Double[] price) {
        formatCode = code;
        bundles = bundle;
        prices = price;
    }
}
