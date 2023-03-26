import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private Map<Integer, Integer> val2Index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        val2Index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            val2Index.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart >= inEnd) return null;
        int nodeVal = postOrder[postEnd - 1];
        TreeNode node = new TreeNode(nodeVal);
        int index = val2Index.get(nodeVal);
        node.left = buildTree(inorder, inStart, index, postOrder, postStart, postStart + index - inStart);
        node.right = buildTree(inorder, index + 1, inEnd, postOrder, postStart + index - inStart, postEnd - 1);
        return node;
    }
}

