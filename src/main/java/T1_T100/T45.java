package T1_T100;

public class T45 {

    public int jump(int[] nums) {
        int times = 0;
        int reached = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (reached < i) {
                ++times;
                reached = max;
            }
            max = Math.max(max, i + nums[i]);
        }
        return times;
    }
}
