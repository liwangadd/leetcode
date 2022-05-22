package leetcode.T600_T700;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class T655 {

    private List<List<String>> res;

    private int colIndex;

    private int height;

    public List<List<String>> printTree(TreeNode root) {
        res = new LinkedList<>();
        if (root == null) return res;
        this.colIndex = 0;
        this.height = getHeight(root);
        helper(root, 0);
        for (List<String> row : res) {
            while (row.size() <= colIndex) row.add("");
        }
        return res;
    }

    private void helper(TreeNode node, int rowIndex) {
        if (res.size() <= rowIndex) res.add(new LinkedList<>());
        if (rowIndex < height) {
            helper(node == null ? null : node.left, rowIndex + 1);
            List<String> row = res.get(rowIndex);
            while (row.size() < colIndex) row.add("");
            row.add((node == null ? "" : String.valueOf(node.val)));
            ++colIndex;
            helper(node == null ? null : node.right, rowIndex + 1);
        }
    }

    private int getHeight(TreeNode node) {
        return node == null ? 0 : Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

}
