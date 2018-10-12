package T1_T100;

public class T55 {

    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length && reach >= i; ++i) {
            if (i + nums[i] > reach) reach = i + nums[i];
        }
        return reach >= nums.length - 1;
    }

}
