public class T189 {

    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int[] newNums = new int[len];
        for (int i = 0; i < len; ++i) {
            int newPos = (i + k) % len;
            newNums[newPos] = nums[i];
        }
        for (int i = 0; i < len; ++i) {
            nums[i] = newNums[i];
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }

}
