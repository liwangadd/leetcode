package leetcode.T300_T400;

public class T330 {

    public int minPatches(int[] nums, int n) {
        long mis = 1;
        int index = 0, res = 0;
        while (mis <= n) {
            if (index < nums.length && nums[index] <= mis) {
                mis += nums[index++];
            } else {
                mis += mis;
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T330 solution = new T330();
        System.out.println(solution.minPatches(new int[]{1, 3}, 6));
        System.out.println(solution.minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(solution.minPatches(new int[]{1, 2, 2}, 5));
        System.out.println(solution.minPatches(new int[]{1, 2, 31, 33}, 2147483647));
    }

}
