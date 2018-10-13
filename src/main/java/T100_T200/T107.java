package T100_T200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T107 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

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
        List<List<Integer>> result = new ArrayList<>();
        for (int i = res.size() - 1; i > -1; --i) {
            result.add(res.get(i));
        }
        return result;
    }

}
