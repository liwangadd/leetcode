package leetcode.T1_T100;

public class T80 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = nums[0], count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == pre) {
                if (count < 2) {
                    nums[index++] = nums[i];
                    ++count;
                }
            } else {
                nums[index++] = nums[i];
                pre = nums[i];
                count = 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int index = removeDuplicates(nums);
        for (int i = 0; i < index; ++i) {
            System.out.println(nums[i]);
        }
    }

}
