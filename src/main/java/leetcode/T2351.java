package leetcode;

import apple.laf.JRSUIConstants;

import java.util.Set;

public class T2351 {

    public char repeatedCharacter(String s) {
        char[] sArr = s.toCharArray();
        boolean[] appear = new boolean[26];
        for (char c : sArr) {
            if (appear[c - 'a'])
                return c;
            else
                appear[c - 'a'] = true;
        }
        return ' ';
    }

}
