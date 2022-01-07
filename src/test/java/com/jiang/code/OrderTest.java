package com.jiang.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testExceptionIsThrown() {
        Order tester = new Order();
        assertThrows(IllegalArgumentException.class, () -> tester.getMediaNumber("img"));
        assertThrows(IllegalArgumentException.class, () -> tester.getMediaNumber("IMG"));
    }

    @Test
    void testGetMediaNumber() {
        Order tester = new Order();
        ArrayList<String> testOrders = new ArrayList<>();
        testOrders.add("11 IMG");
        tester.setOrders(testOrders);
        assertEquals(11, tester.getMediaNumber("IMG"));
    }
}