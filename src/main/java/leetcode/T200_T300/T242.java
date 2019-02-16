package leetcode.T200_T300;

import java.util.Arrays;

public class T242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] flag1 = new int[26];
        int[] flag2 = new int[26];
        for (int i = 0, len = s.length(); i < len; ++i) {
            flag1[s.charAt(i) - 'a']++;
            flag2[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(flag1, flag2);
    }

}
