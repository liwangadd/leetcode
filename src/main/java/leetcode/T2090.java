package leetcode;

import java.util.Arrays;

public class T2090 {

    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        int left = 0, right = 0, count = 2 * k + 1;
        long sum = 0;
        Arrays.fill(res, -1);
        for (; right < nums.length; ++right) {
            sum += nums[right];
            if (right - left + 1 == 2 * k + 1) {
                res[right - k] = (int) (sum / count);
                sum -= nums[left++];
            }
        }
        return res;
    }

}
