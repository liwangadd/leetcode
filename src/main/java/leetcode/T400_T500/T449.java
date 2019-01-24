package leetcode.T400_T500;

import utils.TreeNode;

public class T449 {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode node, StringBuilder sb) {
            if(node==null) return;
            sb.append(node.val).append(" ");
            serialize(node.left, sb);
            serialize(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] nodes = data.split(" ");
            TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
            for (int i = 1; i < nodes.length; i++) {
                insert(root, Integer.valueOf(nodes[i]));
            }
            return root;
        }

        private void insert(TreeNode root, int val) {
            TreeNode cur = root, parent = root;
            while (cur != null) {
                parent = cur;
                cur = cur.val < val ? cur.right : cur.left;
            }
            if (parent.val < val) {
                parent.right = new TreeNode(val);
            } else {
                parent.left = new TreeNode(val);
            }
        }
    }

}
