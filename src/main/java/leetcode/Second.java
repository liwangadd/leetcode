package leetcode;

import javafx.scene.transform.Rotate;
import utils.ListNode;
import utils.TreeNode;

import java.util.*;

public class Second {

    public int countNodes(TreeNode root) {
        int depthLeft = depth(root.left);
        int depthRight = depth(root.right);
        if (depthLeft == depthRight) {
            return (int) Math.pow(2, depthLeft) + countNodes(root.right);
        } else {
            return (int) Math.pow(2, depthRight) + countNodes(root.left);
        }
    }

    private int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.left;
            ++depth;
        }
        return depth;
    }

    public static void main(String[] args) {
        Second solution = new Second();
//        solution.candy(new int[]{1, 3, 4, 5, 2});
//        solution.add();
//        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
//        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
//        for (int num : solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)) {
//            System.out.println(num);
//        }
    }

}
