import java.util.Arrays;

public class T75 {

    private static void sortColors(int[] nums) {
//        for (int i = 0; i < nums.length; ++i) {
//            int min = nums[i];
//            int minIndex = i;
//            for (int j = i + 1; j < nums.length; ++j) {
//                if (nums[j] < min) {
//                    min = nums[j];
//                    minIndex = j;
//                }
//            }
//            if (minIndex != i) {
//                int temp = nums[minIndex];
//                nums[minIndex] = nums[i];
//                nums[i] = temp;
//            }
//        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
