package leetcode.T500_T600;

import java.awt.font.NumericShaper;
import java.util.HashMap;
import java.util.Map;

public class T523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer prev = map.get(sum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new T523().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13);
    }

}
