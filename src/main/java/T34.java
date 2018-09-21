public class T34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                res[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > -1; --i) {
            if (nums[i] == target) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

}
