package basic.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraverse {

    public void recursionPreOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            recursionPreOrder(root.left);
            recursionPreOrder(root.right);
        }
    }

    public void preOrder(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        nodes.push(root);
        while (!nodes.empty() || node != null) {
            while (node != null) {
                System.out.println(node.val);
                nodes.push(node);
                node = node.left;
            }
            if (!nodes.empty()) {
                node = nodes.pop().right;
            }
        }
    }

    public void recursionInOrder(TreeNode root) {
        if (root != null) {
            recursionInOrder(root.left);
            System.out.println(root.val);
            recursionInOrder(root.right);
        }
    }

    public void inOrder(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        while (!nodes.empty() || node != null) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
            if (!nodes.empty()) {
                node = nodes.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    public void recursionPostOrder(TreeNode root) {
        if (root != null) {
            recursionPostOrder(root.left);
            recursionPostOrder(root.right);
            System.out.println(root.val);
        }
    }

    public void postOrder(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !nodes.empty()) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
            node = nodes.peek();
            if (node.right == null || node.right == lastVisit) {
                System.out.println(node.val);
                nodes.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }

    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- != 0) {
                TreeNode node = nodes.poll();
                System.out.println(node.val);
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
            }
        }
    }

}
