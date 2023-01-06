package leetcode;

import java.util.Arrays;

public class T1833 {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0, len = costs.length;
        for (; count < len && coins - costs[count] >= 0; ++count) {
            coins -= costs[count];
        }
        return count;
    }

}
