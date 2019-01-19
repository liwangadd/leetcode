package leetcode.T1_T100;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class T95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n <= 0) return res;
        return getSubTree(1, n);
    }

    private List<TreeNode> getSubTree(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTrees = getSubTree(start, i - 1);
            List<TreeNode> rightSubTrees = getSubTree(i + 1, end);
            for (TreeNode leftSubTree : leftSubTrees) {
                for (TreeNode rightSubTree : rightSubTrees) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = leftSubTree;
                    currentNode.right = rightSubTree;
                    res.add(currentNode);
                }
            }
        }
        return res;
    }

}
