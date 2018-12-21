package leetcode.T1_T100;

import java.util.Arrays;

public class T87 {

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        char a1[], a2[];
        a1 = s1.toCharArray();
        a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (!(new String(a1).equals(new String(a2))))
            return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }
}
