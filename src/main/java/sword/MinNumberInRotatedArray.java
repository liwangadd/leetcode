package sword;

public class MinNumberInRotatedArray {

    public int min(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[mid] && nums[mid] == nums[right])
                return minNumber(nums, left, right);
            else if (nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }

    private int minNumber(int[] nums, int left, int right) {
        for (int i = left; i < right; ++i) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[left];
    }


}
