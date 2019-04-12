package leetcode.T600_T700;

import utils.TreeNode;

public class T606 {

    private StringBuilder sb;

    public String tree2str(TreeNode node) {
        if (node == null) return "";
        sb = new StringBuilder();
        node2str(node);
        return sb.substring(1,sb.length()-1);
    }

    private void node2str(TreeNode node) {
        if (node == null) return;
        sb.append("(");
        sb.append(node.val);
        if (node.left != null)
            node2str(node.left);
        else if (node.right != null) {
            sb.append("()");
        }
        node2str(node.right);
        sb.append(")");
    }

}
