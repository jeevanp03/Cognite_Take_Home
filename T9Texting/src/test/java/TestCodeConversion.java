package T9Texting.src.test.java;

import T9Texting.src.main.java.CodeConversion;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.HashSet;

public class TestCodeConversion {
    CodeConversion demoConversion1;
    HashMap<String, String[]> map;

    @BeforeEach
    void setUpCase1() {
        demoConversion1 = new CodeConversion("4663");
    }

    CodeConversion demoConversion2;

    @BeforeEach
    void setUpCase2() {
        map = new HashMap<>();
        map.put("1", new String[] { " " });
        map.put("2", new String[] { "A", "B", "C" });
        map.put("3", new String[] { "D", "E", "F" });
        map.put("4", new String[] { "G", "H", "I" });
        map.put("5", new String[] { "J", "K", "L" });
        map.put("6", new String[] { "M", "N", "O" });
        map.put("7", new String[] { "P", "Q", "R", "S" });
        map.put("8", new String[] { "T", "U", "V" });
        map.put("9", new String[] { "W", "X", "Y", "Z" });
        map.put("*", new String[] { " " });
        map.put("0", new String[] { "_" });
        map.put("#", new String[] { " " });
        demoConversion2 = new CodeConversion("4663", map);
    }

    @Test
    public void testGenerateCombinations1() {
        Set<String> results = new HashSet<>();
        results = demoConversion1.generateCombinations("4663", "", demoConversion1.getMap(), results, 0);
        assertEquals(81, results.size());
    }

    @Test
    public void testGenerateCombinations2() {
        Set<String> results = new HashSet<>();
        results = demoConversion1.generateCombinations("4663", "", demoConversion2.getMap(), results, 0);
        assertEquals(81, results.size());
    }

    @Test
    public void testGenerateCombinations3() {
        Set<String> results = new HashSet<>();
        results = demoConversion1.generateCombinations("4667", "", demoConversion1.getMap(), results, 0);
        assertEquals(108, results.size());
    }

    @Test
    public void testGenerateCombinations4() {
        Set<String> results = new HashSet<>();
        results = demoConversion1.generateCombinations("4667", "", demoConversion2.getMap(), results, 0);
        assertEquals(108, results.size());
    }

    @Test
    public void testGenerateCombinations5() {
        Set<String> results = new HashSet<>();
        results = demoConversion1.generateCombinations("3667", "", demoConversion1.getMap(), results, 0);
        assertEquals(108, results.size());
    }

    @Test
    public void testGenerateCombinations6() {
        Set<String> results = new HashSet<>();
        results = demoConversion1.generateCombinations("3667", "", demoConversion2.getMap(), results, 0);
        assertEquals(108, results.size());
    }

    @Test
    public void testGetCode1() {
        assertEquals("4663", demoConversion1.getCode());
    }

    @Test
    public void testGetCode2() {
        Set<String> results = new HashSet<>();
        results = demoConversion1.generateCombinations("3667", "", demoConversion1.getMap(), results, 0);
        assertEquals("3667", demoConversion1.getCode());
    }

    @Test
    public void testGetMap1() {
        assertEquals(12, demoConversion1.getMap().size());
    }

    @Test
    public void testGetMap2() {
        assertEquals(12, demoConversion2.getMap().size());
    }

}
