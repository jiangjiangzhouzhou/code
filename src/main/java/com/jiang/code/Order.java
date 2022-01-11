package com.jiang.code;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NonNull
public class Order {
    private HashMap<String, Integer> orders = new HashMap<>();

    public int getOrderNUmber(String str){
        return orders.get(str) != null ? orders.get(str) : 0 ;
    }
}
