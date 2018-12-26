package leetcode.T300_T400;

import java.util.Random;

public class T398 {

    private int[] nums;
    private Random random;

    public T398(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != target) continue;
            if (random.nextInt(count) == 0) res = i;
            ++count;
        }
        return res;
    }

}
