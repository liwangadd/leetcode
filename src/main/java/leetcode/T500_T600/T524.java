package leetcode.T500_T600;

import java.util.Collections;
import java.util.List;

public class T524 {

    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
        for (String dictWord : dictionary) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            if (i == dictWord.length()) return dictWord;
        }
        return "";
    }

}
