package leetcode;

import java.util.Arrays;

public class T2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int start = 0, end = potions.length;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if ((long) potions[mid] * spells[i] >= success) end = mid;
                else start = mid + 1;
            }
            res[i] = potions.length - start;
        }
        return res;
    }

}
