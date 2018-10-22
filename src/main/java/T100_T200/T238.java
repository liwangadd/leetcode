package T100_T200;

import sun.security.util.Length;

public class T238 {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i > 0; --i) {
            res[i] *= right;
            right *= res[i];
        }
        return res;
    }

}
