package leetcode;

public class T1752 {

    public boolean check(int[] nums) {
        int n = nums.length;
        int irr_reg = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                irr_reg++;
            }
        }

        return irr_reg <= 1;
    }
}
