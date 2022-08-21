package leetcode.T900_T1000;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T919 {

    private TreeNode root;

    private Queue<TreeNode> parentQueue = new LinkedList<>(), childQueue = new LinkedList<>();

    public T919(TreeNode root) {
        this.root = root;
        if (root != null) {
            parentQueue.offer(root);
            while (parentQueue.peek().left != null) {
                TreeNode node = parentQueue.peek();
                childQueue.offer(node.left);
                if (node.right != null) {
                    childQueue.offer(node.right);
                    parentQueue.poll();
                    if (parentQueue.isEmpty()) {
                        parentQueue = childQueue;
                        childQueue = new LinkedList<>();
                    }
                } else {
                    break;
                }
            }
        }
    }

    public int insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            parentQueue.offer(root);
            return -1;
        } else {
            TreeNode node = parentQueue.peek();
            if (node.left == null) {
                node.left = new TreeNode(val);
                childQueue.offer(node.left);
            } else if (node.right == null) {
                node.right = new TreeNode(val);
                childQueue.offer(node.right);
                parentQueue.poll();
                if (parentQueue.isEmpty()) {
                    parentQueue = childQueue;
                    childQueue = new LinkedList<>();
                }
            }
            return node.val;
        }
    }

    public TreeNode get_root() {
        return root;
    }

}
