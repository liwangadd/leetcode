package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T1002 {

    public List<String> commonChars(String[] words) {
        int[] minHolders = new int[26];
        Arrays.fill(minHolders, Integer.MAX_VALUE);
        for (String word : words) {
            char[] wordArr = word.toCharArray();
            int[] holders = new int[26];
            for (char c : wordArr) {
                holders[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minHolders[i] = Math.min(minHolders[i], holders[i]);
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i < minHolders.length; i++) {
            while (minHolders[i] > 0) {
                res.add(String.valueOf((char) (i + 'a')));
                --minHolders[i];
            }
        }
        return res;
    }

}
