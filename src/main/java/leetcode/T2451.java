package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T2451 {

    public String oddString(String[] words) {
        int len = words[0].length();
        Map<String, Integer> keyMap = new HashMap<>();
        Map<String, String> valueMap = new HashMap<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len - 1; i++) {
                int diff = word.charAt(i + 1) - word.charAt(i);
                sb.append(diff).append("|");
            }
            keyMap.put(sb.toString(), keyMap.getOrDefault(sb.toString(), 0) + 1);
            valueMap.put(sb.toString(), word);
        }
        for (Map.Entry<String, Integer> entry : keyMap.entrySet()) {
            if (entry.getValue() == 1) return valueMap.get(entry.getKey());
        }
        return null;
    }

    public static void main(String[] args) {
        new T2451().oddString(new String[]{
                "abm", "bcn", "alm"
        });
    }

}
