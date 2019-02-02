package leetcode.T200_T300;

import java.util.*;

public class T269 {

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        Map<Character, Integer> indgrees = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) indgrees.put(word.charAt(i), 0);
        }
        for (int i = 1; i < words.length; ++i) {
            int len1 = words[i - 1].length(), len2 = words[i].length();
            int index = 0;
            while (words[i].charAt(index) == words[i - 1].charAt(index)) ++index;
            if (index >= Math.min(len1, len2)) continue;
            indgrees.put(words[i].charAt(index), indgrees.getOrDefault(words[i].charAt(index), 0) + 1);
            if (map.containsKey(words[i - 1].charAt(index))) {
                map.get(words[i - 1].charAt(index)).add(words[i].charAt(index));
            } else {
                Set<Character> set = new HashSet<>();
                set.add(words[i].charAt(index));
                map.put(words[i - 1].charAt(index), set);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!indgrees.isEmpty()) {
            char ch = ' ';
            for (Map.Entry<Character, Integer> entry : indgrees.entrySet()) {
                if (entry.getValue() == 0) {
                    ch = entry.getKey();
                    break;
                }
            }
            if (ch == ' ') return "";
            sb.append(ch);
            indgrees.remove(ch);
            if (map.containsKey(ch)) {
                for (Character c : map.get(ch)) {
                    indgrees.put(c, indgrees.get(c) - 1);
                }
            }
        }
        return sb.toString();
    }

}
