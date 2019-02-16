package leetcode.T200_T300;

import java.util.Arrays;

public class T280 {

    public void wiggleSort(int[] nums) {
        // write your code here
        for (int i = 0; i < nums.length - 1; ++i) {
            if (i % 2 == 0 && nums[i + 1] < nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
            if (i % 2 == 1 && nums[i + 1] > nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
    }

}
