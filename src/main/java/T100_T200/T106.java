package T100_T200;

import utils.TreeNode;

public class T106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return buildTree(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart == inEnd) return null;
        TreeNode node = new TreeNode(postorder[postEnd - 1]);
        int pos = inStart;
        for (; pos < inEnd; ++pos) {
            if (inorder[pos] == node.val) break;
        }
        node.left = buildTree(inorder, postorder, inStart, pos, postStart, postStart + pos - inStart);
        node.right = buildTree(inorder, postorder, pos + 1, inEnd, postStart + pos - inStart, postEnd - 1);
        return node;
    }

}
