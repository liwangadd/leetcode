package leetcode;

import utils.ListNode;
import utils.TreeNode;

import java.util.*;

public class Second {

    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            ++fast;
        }
        return slow+1;
    }

    public static void main(String[] args) {
        Second solution = new Second();
//        System.out.println(solution.isValid("{[]}"));
//        for (int num : solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)) {
//            System.out.println(num);
//        }
    }

}
