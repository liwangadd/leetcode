package leetcode.T700_T800;

public class T795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = 0, end = 0;
        int pre = 0;
        int res = 0;

        while (end < nums.length) {
            if (nums[end] >= left && nums[end] <= right) {
                pre = end - start + 1;//if in range adding all subarrays including the curr element
                res += pre;
            } else if (nums[end] < left) {
                res += pre;// if curr ele less than left then add all the subarrays except the subarray with only one elemnt with curr ele val.
            } else {
                start = end + 1;
                pre = 0;
            }
            end++;
        }

        return res;
    }
}
