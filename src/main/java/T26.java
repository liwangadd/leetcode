public class T26 {

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lastCharacter = nums[0];
        int lastIndex = 1;
        for (int i = 1, len = nums.length; i < len; ++i) {
            if (nums[i] != lastCharacter) {
                lastCharacter = nums[i];
                nums[lastIndex++] = nums[i];
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
