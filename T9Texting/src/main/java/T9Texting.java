package T9Texting.src.main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class T9Texting {
    public static void main(String[] args) {
        Map<String, Interfaces.WordChecker> stubbedDictionary = new HashMap<>();
        stubbedDictionary.put("isWord", input -> input.length() % 2 == 0);

        // stubbedDictionary.put("isWord", input -> checkingFunction(input, new String[]
        // { "HOME", "GONE", "GOOD", "HOOD" }));

        Set<String> words = findWords("4663", stubbedDictionary);
        for (String word : words) {
            System.out.println(word);
        }
    }

    private static boolean checkingFunction(String input, String[] words) {
        for (String word : words) {
            if (word.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static Set<String> findWords(String code, Map<String, Interfaces.WordChecker> stubbedDictionary) {
        CodeConversion conversion = new CodeConversion(code);
        Set<String> results = new HashSet<>();
        results = conversion.generateCombinations(code, "", conversion.getMap(), results, 0);
        results = results.stream()
                .filter(result -> stubbedDictionary.get("isWord").isWord(result))
                .collect(Collectors.toSet());

        return results;
    }

}