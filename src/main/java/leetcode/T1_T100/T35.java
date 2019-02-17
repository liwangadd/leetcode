package leetcode.T1_T100;

public class T35 {

    private static int searchInsert(int[] nums, int target) {
        int insertPos = 0;
        while (insertPos < nums.length) {
            if (nums[insertPos] >= target) {
                break;
            }
            ++insertPos;
        }
//        if (insertPos == nums.length) return nums.length;
        return insertPos;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }

}
