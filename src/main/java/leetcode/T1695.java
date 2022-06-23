package leetcode;

import java.util.Set;

public class T1695 {

    public int maximumUniqueSubarray(int[] nums) {
        boolean[] holders = new boolean[10001];
        int left = 0, right = 0, res = -1, sum = 0;
        for (; right < nums.length; ++right) {
            while (holders[nums[right]]) {
                holders[nums[left]] = false;
                sum -= nums[left++];
            }
            holders[nums[right]] = true;
            sum += nums[right];
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        new T1695().maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6});
    }

}
