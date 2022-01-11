package com.jiang.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiverTest {
    @Test
    void testExceptionIsThrown() {
        Receiver tester = new Receiver();
        assertThrows(IllegalArgumentException.class, tester::receiveInputs);
    }

}