package leetcode;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int size_t = size;
            boolean hasNull = false;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (hasNull) return false;
                    queue.add(node.left);
                } else {
                    hasNull = true;
                }
                if (node.right != null) {
                    if (hasNull) return false;
                    queue.add(node.right);
                } else {
                    hasNull = true;
                }
            }
            if (!queue.isEmpty() && size_t != Math.pow(2, level)) return false;
            ++level;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        boolean res = new T958().isCompleteTree(root);
        System.out.println(res);
    }

}
