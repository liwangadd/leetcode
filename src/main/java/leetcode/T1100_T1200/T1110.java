package leetcode.T1100_T1200;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T1110 {

    private List<TreeNode> res;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.res = new ArrayList<>();
        Set<Integer> deletedNodes = new HashSet<>();
        for (int val : to_delete) {
            deletedNodes.add(val);
        }
        if(!deletedNodes.contains(root.val)) this.res.add(root);
        removeNodes(root, deletedNodes);
        return this.res;
    }

    private TreeNode removeNodes(TreeNode node, Set<Integer> deletedNodes) {
        if (node == null) return null;
        TreeNode leftNode = removeNodes(node.left, deletedNodes);
        TreeNode rightNode = removeNodes(node.right, deletedNodes);
        if (leftNode == null) node.left = null;
        if (rightNode == null) node.right = null;
        if (deletedNodes.contains(node.val)) {
            if (leftNode != null) this.res.add(leftNode);
            if (rightNode != null) this.res.add(rightNode);
            return null;
        }
        return node;
    }

}
