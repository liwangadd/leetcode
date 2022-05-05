package leetcode.T200_T300;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.append("[]").toString();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean shellBreak = true;
            while (count-- != 0) {
                TreeNode node = queue.poll();
                if (node == null) sb.append("null,");
                else {
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                    if (node.left != null || node.right != null) {
                        shellBreak = false;
                    }
                }
            }
            if (shellBreak) break;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1);
        String[] itemStrs = data.split(",");

        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(itemStrs[index++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (index < itemStrs.length) {
            TreeNode node = queue.poll();
            if (!itemStrs[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(itemStrs[index]));
                queue.add(node.left);
            }
            ++index;
            if (index < itemStrs.length && !itemStrs[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(itemStrs[index]));
                queue.add(node.right);
            }
            ++index;
        }
        return root;
    }

    public static void main(String[] args) {
        T297 solution = new T297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(solution.serialize(root));

        System.out.println(solution.deserialize("[]"));
    }

}
