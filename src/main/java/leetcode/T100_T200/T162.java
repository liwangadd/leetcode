package leetcode.T100_T200;

public class T162 {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] > nums[mid2]) right = mid1;
            else left = mid2;
        }
        return left;
    }

}
