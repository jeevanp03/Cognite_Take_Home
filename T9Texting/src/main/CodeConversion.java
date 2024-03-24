package T9Texting.src.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CodeConversion {
    private String code;
    private Map<String, String[]> map;

    public CodeConversion(String code) {
        this.code = code;
        this.map = new HashMap<>();
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
    }

    public CodeConversion(String code, Map<String, String[]> map) {
        this.code = code;
        this.map = map;
    }

    public Set<String> generateCombinations(String sequence, String currentPrefix, Map<String, String[]> map,
            Set<String> results) {
        if (sequence.trim().length() == 0) {
            results.add(currentPrefix);
            return results;
        }

        String currentDigit = sequence.charAt(0) + "";
        String[] letters = map.get(currentDigit);
        for (String letter : letters) {
            String newPrefix = currentPrefix + letter;
            String remainingSequence = sequence.substring(1);
            generateCombinations(remainingSequence, newPrefix, map, results);
        }

        return results;
    }

    public String getCode() {
        return code;
    }

    public Map<String, String[]> getMap() {
        return map;
    }
}