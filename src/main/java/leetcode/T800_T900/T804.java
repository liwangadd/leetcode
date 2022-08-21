package leetcode.T800_T900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T804 {

    private Map<Character, String> prepareTransformers() {
        String[] dashes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Map<Character, String> transformers = new HashMap<>();
        for (int i = 0; i < dashes.length; i++) {
            transformers.put((char) ('a' + i), dashes[i]);
        }
        return transformers;
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> container = new HashSet<>();
        Map<Character, String> transformers = prepareTransformers();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(transformers.get(c));
            }
            container.add(sb.toString());
        }
        return container.size();
    }

}
