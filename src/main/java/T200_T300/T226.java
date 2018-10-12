package T200_T300;

public class T226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree1(root);
        return root;
    }

    public void invertTree1(TreeNode node) {
        if (node != null) {
            invertTree1(node.left);
            invertTree1(node.right);
            TreeNode leftTmp = node.left;
            node.left = node.right;
            node.right = leftTmp;
        }
    }

}
