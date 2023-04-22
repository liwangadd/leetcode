package leetcode;

import java.util.Arrays;

public class T2399 {

    public boolean checkDistances(String s, int[] distance) {
        int[] actualDistance = new int[26];
        Arrays.fill(actualDistance, -1);
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            int pos = sArr[i] - 'a';
            actualDistance[pos] = actualDistance[pos] == -1 ? i : i - actualDistance[pos] - 1;
        }
        for (int i = 0; i < 26; i++) {
            if (actualDistance[i] != -1 && actualDistance[i] != distance[i]) {
                return false;
            }
        }
        return true;
    }

}
