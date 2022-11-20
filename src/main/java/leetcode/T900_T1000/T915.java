package leetcode.T900_T1000;

import java.util.ArrayDeque;
import java.util.Deque;

public class T915 {

    public int partitionDisjoint(int[] nums) {
        int[] minArr = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            int index = i;
            if (i < nums.length - 1 && nums[minArr[i + 1]] < nums[i]) {
                index = minArr[i + 1];
            }
            minArr[i] = index;
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max <= nums[minArr[i + 1]])
                return i + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new T915().partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
    }

}
