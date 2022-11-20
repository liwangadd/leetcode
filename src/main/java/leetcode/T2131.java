package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T2131 {

    public int longestPalindrome(String[] words) {
        int pairCount = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String swapWord = swap(word);
            if (map.containsKey(swapWord) && map.get(swapWord) > 0) {
                ++pairCount;
                int count = map.get(swapWord) - 1;
                if (count == 0) {
                    map.remove(swapWord);
                } else {
                    map.put(swapWord, count - 1);
                }
                map.put(swapWord, map.get(swapWord));
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1)) return pairCount * 4 + 2;
        }
        return pairCount * 4;
    }

    private String swap(String word) {
        char[] chars = word.toCharArray();
        char holder = chars[0];
        chars[0] = chars[1];
        chars[1] = holder;
        return new String(chars);
    }

}
