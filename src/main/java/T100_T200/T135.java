package T100_T200;

public class T135 {

    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) nums[i] = nums[i - 1] + 1;
            else nums[i] = 1;
        }
        int res = 0;
        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i - 1] > ratings[i] && nums[i - 1] <= nums[i]) {
                nums[i - 1] = nums[i] + 1;
            }
            res += nums[i];
        }
        res += nums[0];
        return res;
    }

}
