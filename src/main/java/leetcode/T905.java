package leetcode;

public class T905 {

    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 0) ++left;
            while (left < right && (nums[right] & 1) == 1) --right;
            swap(nums, left, right);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
