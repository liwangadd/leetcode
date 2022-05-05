package leetcode.T500_T600;

public class T581 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        for (; left < right; ++left) {
            boolean flag = false;
            for (int i = left + 1; i < nums.length; ++i) {
                if (nums[i] < nums[left]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        for (; right > left; --right) {
            boolean flag = false;
            for (int i = right - 1; i >= left; --i) {
                if (nums[i] > nums[right]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (left >= right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new T581().findUnsortedSubarray(new int[]{0,1,4,5,3,7,2,6,8,9}));
    }
}
