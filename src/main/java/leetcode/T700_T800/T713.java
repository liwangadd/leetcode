package leetcode.T700_T800;

public class T713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, multi = 1, left = 0, right = 0;
        for (; right < nums.length; ++right) {
            multi *= nums[right];
            while (multi >= k && left <= right) multi /= nums[left++];
            res += (right - left + 1);
        }
        return res;
    }

}
