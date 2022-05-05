package leetcode;

import java.util.Arrays;

public class T1679 {

    public int maxOperations(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < k) {
                ++left;
            } else if (nums[left] + nums[right] > k) {
                --right;
            } else {
                ++count;
                ++left;
                --right;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new T1679().maxOperations(new int[]{3, 1, 3, 4, 3}, 5));
    }

}
