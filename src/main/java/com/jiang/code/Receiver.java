package com.jiang.code;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Receiver {
    private List<String> inputs = new ArrayList<>();

    //Get order from input
    public void receiveInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your order and press # to stop");
        String newString;
        while (sc.hasNextInt()) {
            newString = sc.nextLine();
            int number = Integer.parseInt(newString.replaceAll("[^0-9]", ""));
            if (number < 0) {
                throw new IllegalArgumentException("The number of items must be bigger than 0.");
            }
            if (newString.equals("#")) {
                sc.close();
            }
            inputs.add(newString);
        }
    }
}
