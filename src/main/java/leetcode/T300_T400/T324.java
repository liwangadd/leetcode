package leetcode.T300_T400;

import java.util.Arrays;

public class T324 {

    public void wiggleSort(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return;
        Arrays.sort(nums);
        int[] res = new int[nums.length];

        int low = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1, high = 1;
        for (int i = 0; low >= 0; ++i, low -= 2) {
            res[low] = nums[i];
        }
        for (int i = nums.length - 1; high < nums.length; --i, high += 2) {
            res[high] = nums[i];
        }

        System.arraycopy(res, 0, nums, 0, res.length);
    }

    public static void main(String[] args) {
        T324 solution=new T324();
        int[] nums = {4,5,5,6};
        solution.wiggleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
