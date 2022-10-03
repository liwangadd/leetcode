package leetcode;

import java.util.Arrays;

public class T1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] indexes = new int[26];
        Arrays.fill(indexes, -1);
        char[] sArr = s.toCharArray();
        int maxLen = -1;
        for (int i = 0; i < sArr.length; i++) {
            if (indexes[sArr[i] - 'a'] == -1) indexes[sArr[i] - 'a'] = i;
            else maxLen = Math.max(maxLen, i - indexes[sArr[i] - 'a'] - 1);
        }
        return maxLen;
    }

}
