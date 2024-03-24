package T9Texting.src.test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import T9Texting.src.main.java.Interfaces;
import T9Texting.src.main.java.T9Texting;
import T9Texting.src.main.java.Interfaces.WordChecker;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class TestT9Textubg {
    Map<String, WordChecker> stubbedDictionary1;

    @BeforeEach
    void setUpCase1() {
        stubbedDictionary1 = new HashMap<>();
        stubbedDictionary1.put("isWord", input -> input.length() % 2 == 0);
    }

    HashMap<String, Interfaces.WordChecker> stubbedDictionary2;

    @BeforeEach
    void setUpCase2() {
        stubbedDictionary2 = new HashMap<>();
        stubbedDictionary2.put("isWord",
                input -> checkingFunction(input, new String[] { "HOME", "GONE", "GOOD", "HOOD" }));
    }

    HashMap<String, Interfaces.WordChecker> stubbedDictionary3;

    @BeforeEach
    void setUpCase3() {
        stubbedDictionary3 = new HashMap<>();
        stubbedDictionary3.put("isWord",
                input -> checkingFunction(input, new String[] { "GREAT" }));
    }

    private static boolean checkingFunction(String input, String[] words) {
        for (String word : words) {
            if (word.equals(input)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testFindWords1() {
        assertEquals(81, T9Texting.findWords("4663", stubbedDictionary1).size());
    }

    @Test
    public void testFindWords2() {
        assertEquals(4, T9Texting.findWords("4663", stubbedDictionary2).size());
    }

    @Test
    public void testFindWords3() {
        Set<String> expected = new HashSet<>();
        expected.add("HOME");
        expected.add("GOOD");
        expected.add("GONE");
        expected.add("HOOD");
        assertEquals(expected, T9Texting.findWords("4663", stubbedDictionary2));
    }

    @Test
    public void testFindWords4() {
        Set<String> expected = new HashSet<>();
        expected.add("GREAT");
        assertEquals(expected, T9Texting.findWords("47328", stubbedDictionary3));
    }

}
