package T100_T200;

import utils.TreeNode;

public class T105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = inStart;
        for (; index < inEnd; ++index) {
            if (inorder[index] == preorder[preStart]) break;
        }
        node.left = buildTree(preorder, inorder, preStart + 1, preStart + index - inStart + 1, inStart, index);
        node.right = buildTree(preorder, inorder, preStart + index - inStart + 1, preEnd, index + 1, inEnd);
        return node;
    }

}
