package leetcode;

import utils.TreeNode;

import java.util.LinkedList;

public class T1448 {

    public int goodNodes(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node.left != null) {
                if (node.val < node.left.val) ++res;
                node.left.val = Math.max(node.val, node.left.val);
                queue.addLast(node.left);
            }
            if (node.right != null) {
                if (node.val < node.right.val) ++res;
                node.right.val = Math.max(node.val, node.right.val);
                queue.addLast(node.right);
            }
        }
        return res;
    }

}
