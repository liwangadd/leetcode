package T1_T100;

public class T75 {

    private static void sortColors(int[] nums) {
        int zero = -1, two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i++);
            } else if (nums[i] == 1) {
                ++i;
            } else {
                swap(nums, --two, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
