package T100_T200;

import java.util.Arrays;

public class T169 {

    public int majorityElement(int[] nums) {
        if (nums.length <= 2) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
