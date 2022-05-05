package leetcode;

import java.util.HashSet;
import java.util.Set;

public class T1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        if (words == null || words.length == 0 || allowed == null || allowed.length() == 0) {
            return 0;
        }
        Set<Integer> allowedChars = new HashSet<>();
        for (char allowedChar : allowed.toCharArray()) {
            allowedChars.add(allowedChar - '0');
        }
        int count = 0;
        for (String word : words) {
            for (char wordChar : word.toCharArray()) {
                if (!allowedChars.contains(wordChar - '0')) {
                    ++count;
                    break;
                }
            }
        }
        return words.length - count;
    }

    public static void main(String[] args) {

    }

}
