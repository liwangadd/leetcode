public class T283 {

    private static void moveZeros(int[] nums) {
        int k = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (; k < nums.length; ++k) {
            nums[k] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeros(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
