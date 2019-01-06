package sword;

import utils.TreeNode;

public class NextNodeInBinaryTrees {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, parent;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNext(TreeLinkNode node) {
        if (node == null) return null;
        if (node.right != null) {
            TreeLinkNode cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            while (node.parent != null) {
                TreeLinkNode pNode = node.parent;
                if (pNode.left == node) {
                    return pNode;
                }
                node = node.parent;
            }
        }
        return null;
    }

}
