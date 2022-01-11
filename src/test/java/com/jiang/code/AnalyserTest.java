package com.jiang.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyserTest {
    @Test
    void testGetMediaNumber() {
        Analyser tester = new Analyser();
        HashMap<String, Integer> testResult = new HashMap<>();
        testResult.put("IMG", 11);
        List<String> s = new ArrayList<>();
        s.add("IMG 11");
        assertEquals(testResult, tester.getMediaNumber(s));
    }
}