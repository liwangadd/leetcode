package leetcode.T1_T100;

import java.util.concurrent.TimeUnit;

public class T27 {

    public int removeElement(int[] nums, int val) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[s++] = nums[i];
            }
        }
        return s;
    }

}
