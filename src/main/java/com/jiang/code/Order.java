package com.jiang.code;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Scanner;

@Getter
@Setter
public class Order {
    private int imgNumber;
    private int audioNumber;
    private int videoNumber;

    //Get order from input
    public void getOrder(String imgCode, String audCode, String vidCode) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your order and press # to stop");
        while (sc.hasNextInt()) {
            String newString = sc.nextLine();
            int number = Integer.parseInt(newString.replaceAll("[^0-9]", ""));
            if (number <= 0 || Arrays.stream(new String[]{imgCode, audCode, vidCode}).noneMatch(newString::contains)) {
                throw new IllegalArgumentException("The number of items must be bigger than 0, format code must be 'IMG', 'Flac' or 'VID'.");
            } else {
                if (newString.contains(imgCode)) {
                    imgNumber = number;
                } else if (newString.contains(audCode)) {
                    audioNumber = number;
                } else if (newString.contains(vidCode)) {
                    videoNumber = number;
                } else if (newString.equals("#")) {
                    sc.close();
                }
            }
        }
    }
}
