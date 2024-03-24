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

        Set<String> words = findWords("4663", stubbedDictionary);
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

    public static Set<String> findWords(String code, Map<String, Interfaces.WordChecker> stubbedDictionary) {
        CodeConversion conversion = new CodeConversion(code);
        Set<String> results = new HashSet<>();
        results = conversion.generateCombinations(code, "", conversion.getMap(), results);
        results = results.stream()
                .filter(result -> stubbedDictionary.get("isWordTwo").isWord(result))
                .collect(Collectors.toSet());

        return results;
    }
}