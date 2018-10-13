package T200_T300;

import java.util.Arrays;

public class T268 {

    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int sum = 0;
        for (int num : nums)
            sum += num;

        return expectedSum - sum;
    }

}
