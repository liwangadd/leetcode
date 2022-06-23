package leetcode.T800_T900;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        for (String word : words) {
            if (word.length() == pattern.length() && isMatch(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isMatch(String word, String pattern) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        boolean[] existed = new boolean[26];
        for (int i = 0; i < word.length(); ++i) {
            int wordChar = word.charAt(i) - 'a';
            int patternChar = pattern.charAt(i) - 'a';
            if (map[wordChar] == -1) {
                if (existed[patternChar]) return false;
                else {
                    existed[patternChar] = true;
                    map[wordChar] = patternChar;
                }
            } else if (map[wordChar] != patternChar) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new T890().findAndReplacePattern(new String[]{"mee"}, "abb");
    }

}
