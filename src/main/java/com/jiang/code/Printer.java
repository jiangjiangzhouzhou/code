package com.jiang.code;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class Printer {
    public void printPost(Post post, int[] bundles, int number) {
        double cost = IntStream.range(0, bundles.length).mapToDouble(i -> post.getPrices()[i] * bundles[i]).sum();
        log.info("{} {} ${}", number, post.getFormatCode(), cost);
        IntStream.range(0, bundles.length).filter(i -> bundles[i] != 0).forEach(f -> log.info("  {} * {} ${}", bundles[f], post.getBundles()[f], post.getPrices()[f] * bundles[f]));
    }
}
