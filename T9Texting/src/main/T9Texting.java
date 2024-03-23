package T9Texting.src.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class T9Texting {
    public static void main(String[] args) {
        Map<String, Interfaces.WordChecker> stubbedDictionary = new HashMap<>();
        stubbedDictionary.put("isWordOne", input -> input.length() % 2 == 0);

        stubbedDictionary.put("isWordTwo", input -> function(input));

        Map<String, String[]> map = new HashMap<>();
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
        Set<String> words = findWords("4663", stubbedDictionary, map);
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static boolean function(String input) {
        for (String word : new String[] { "HOME", "GONE", "GOOD", "HOOD" }) {
            if (word.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static Set<String> findWords(String code, Map<String, Interfaces.WordChecker> stubbedDictionary,
            Map<String, String[]> map) {
        CodeConversion conversion = new CodeConversion(code, map);
        Set<String> results = new HashSet<>();
        results = conversion.generateCombinations(code, "", map, results);
        results = results.stream()
                .filter(result -> stubbedDictionary.get("isWordTwo").isWord(result))
                .collect(Collectors.toSet());

        return results;
    }
}