package leetcode;

import java.util.Arrays;

public class T1658 {

    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        x = sum - x;
        int left = 0, right = 0, windowSize = Integer.MIN_VALUE, windowSum = 0;
        for (; right < nums.length; ++right) {
            windowSum += nums[right];
            while (windowSum > x && left <= right) windowSum -= nums[left++];
            if (windowSum == x)
                windowSize = Math.max(right - left + 1, windowSize);
        }
        return windowSize == Integer.MIN_VALUE ? -1 : nums.length - windowSize;
    }

    public static void main(String[] args) {
        new T1658().minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365);
    }
}
