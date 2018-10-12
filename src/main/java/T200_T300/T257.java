package T200_T300;

import java.util.LinkedList;
import java.util.List;

public class T257 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        binaryTreePaths(root, "", res);
        return res;
    }

    public static void binaryTreePaths(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, path + root.val + "->", res);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, path + root.val + "->", res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        for (String s : binaryTreePaths(root)) {
            System.out.println(s);
        }
    }

}
