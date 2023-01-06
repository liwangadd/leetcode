package leetcode;

import java.util.Arrays;

public class T2389 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int index = Arrays.binarySearch(nums, queries[i]);
            res[i] = Math.abs(index + 1);
        }
        return res;
    }

}
