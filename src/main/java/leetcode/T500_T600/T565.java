package leetcode.T500_T600;

public class T565 {

    public int arrayNesting(int[] nums) {
        int maxsize = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int k = i; nums[k] >= 0; size++) {
                int ak = nums[k];
                nums[k] = -1;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }

}
