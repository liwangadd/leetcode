package leetcode.T500_T600;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class T506 {

    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) return new String[0];
        int[] rankNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(rankNums);
        Map<Integer, Integer> ranks = new HashMap<>();
        for (int i = 0; i < rankNums.length; ++i) {
            ranks.put(rankNums[i], rankNums.length - i);
        }
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int rank = ranks.get(nums[i]);
            if (rank == 1) res[i] = "Gold Medal";
            else if (rank == 2) res[i] = "Silver Medal";
            else if (rank == 3) res[i] = "Bronze Medal";
            else res[i] = String.valueOf(rank);
        }
        return res;
    }

}
