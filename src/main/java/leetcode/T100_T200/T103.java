package leetcode.T100_T200;

import leetcode.utils.TreeNode;

import java.util.*;

public class T103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int currentCount = count;
            count = 0;
            List<Integer> resItem = new LinkedList<>();
            while (currentCount-- > 0) {
                TreeNode node = queue.poll();
                resItem.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    ++count;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    ++count;
                }
            }
            if (reverse) {
                for (int i = 0, len = resItem.size() / 2; i < len; ++i) {
                    Integer item = resItem.get(i);
                    resItem.set(i, resItem.get(resItem.size() - i - 1));
                    resItem.set(resItem.size() - i - 1, item);
                }
            }
            reverse = !reverse;
            res.add(resItem);
        }
        return res;
    }

}
