package leetcode.T400_T500;

public class T453 {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int res = 0;
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }

}
