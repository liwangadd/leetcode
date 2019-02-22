package leetcode;

import javafx.scene.transform.Rotate;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second {

    public boolean canJump(int[] nums) {
        int reached = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (reached < i) return false;
            reached = Math.max(reached, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Second solution = new Second();
//        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
//        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
//        for (int num : solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)) {
//            System.out.println(num);
//        }
    }

}
