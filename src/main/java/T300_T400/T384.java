package T300_T400;

import java.util.Random;
import java.util.Set;

public class T384 {

    private int[] nums;
    private Random random;

    public T384(int[] nums) {
        this.nums = nums;
        this.random = new Random(System.currentTimeMillis());
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int n = this.nums.length;

        int[] res = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int index;
            do {
                index = random.nextInt(n);
            } while (flag[index]);
            res[i] = this.nums[index];
            flag[index] = true;
        }
        return res;
    }

}
