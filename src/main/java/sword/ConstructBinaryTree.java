package sword;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {

    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        if (inorder == null || inorder.length == 0) return null;

        for (int i = 0, len = inorder.length; i < len; ++i) {
            indexForInOrders.put(inorder[i], i);
        }
        return reBuildTree(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode reBuildTree(int[] preorder, int preLeft, int preRight, int inLeft) {
        if (preLeft > preRight) return null;
        TreeNode node = new TreeNode(preorder[preLeft]);
        int leftCount = indexForInOrders.get(preorder[preLeft]) - inLeft;
        node.left = reBuildTree(preorder, preLeft + 1, preLeft + leftCount, inLeft);
        node.right = reBuildTree(preorder, preLeft + leftCount + 1, preRight, inLeft + leftCount + 1);
        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTree solution = new ConstructBinaryTree();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

}
