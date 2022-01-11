package com.jiang.code;

import java.util.HashMap;
import java.util.List;

public class Analyser {
    public HashMap<String, Integer> getMediaNumber(List<String> lists) {
        HashMap<String, Integer> rawOrders = new HashMap<>();
        if (lists.isEmpty()) {
            throw new IllegalArgumentException("There is no order");
        }
        lists.forEach(list-> rawOrders.put(list.replaceAll("[^a-zA-Z]", ""), Integer.parseInt(list.replaceAll("[^0-9]", ""))));
        return rawOrders;
    }
}
