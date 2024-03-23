package T9Texting.src.main;

import java.util.Map;
import java.util.Set;

public class CodeConversion {
    private String code;
    private Map<String, String[]> map;

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