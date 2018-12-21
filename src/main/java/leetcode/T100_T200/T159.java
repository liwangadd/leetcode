package leetcode.T100_T200;

import java.util.HashMap;
import java.util.Map;

public class T159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 2) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, len = 0, diffCount = 0;
        char[] sArr = s.toCharArray();
        while (end < s.length()) {
            if (!map.containsKey(sArr[end])) {
                map.put(sArr[end], 1);
                ++diffCount;
            } else {
                map.put(sArr[end], map.get(sArr[end]) + 1);
            }
            if (diffCount > 2) {
                map.remove(s.charAt(sArr[start]));
                ++start;
                --diffCount;
            }
            len = Math.max(end - start + 1, len);
            ++end;
        }
        return len;
    }

}
