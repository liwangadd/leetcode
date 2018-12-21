package leetcode.T200_T300;

public class T209 {

    private static int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = -1;
        int sum = 0;
        int minLength = nums.length + 1;
        while (left < nums.length) {
            while (sum < s && right < nums.length - 1) {
                sum += nums[++right];
            }
            while (sum >= s) {
                sum -= nums[left++];
            }
            int len = right - left + 2;
            if (len < minLength) minLength = len;
            if (right == nums.length - 1) break;
        }
        if (minLength == nums.length + 1) {
            return 0;
        } else {
            return minLength;
        }
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen(213,
                new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
        System.out.println(minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
    }

}
