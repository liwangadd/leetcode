package leetcode.T100_T200;

import utils.TreeNode;

import java.util.*;

public class T107 {

    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int levelCount = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentCount = 0;
            List<Integer> nodeList = new ArrayList<>();
            while (levelCount-- > 0) {
                TreeNode node = queue.poll();
                nodeList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    ++currentCount;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    ++currentCount;
                }
            }
            levelCount = currentCount;
            res.add(nodeList);
        }
        Collections.reverse(res);
        return res;
    }

}
