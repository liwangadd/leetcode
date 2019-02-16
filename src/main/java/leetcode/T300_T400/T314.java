package leetcode.T300_T400;

import utils.TreeNode;

import java.util.*;

public class T314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        Map<Integer, List<Integer>> hash = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- != 0) {
                Node node = queue.poll();
                if (hash.containsKey(node.value)) {
                    hash.get(node.value).add(node.key.val);
                } else {
                    List<Integer> item = new ArrayList<>();
                    item.add(node.key.val);
                    hash.put(node.value, item);
                }
                if (node.key.left != null) queue.add(new Node(node.key.left, node.value - 1));
                if (node.key.right != null) queue.add(new Node(node.key.right, node.value + 1));
            }
        }
        List<Integer> columns = new ArrayList<>(hash.keySet());
        Collections.sort(columns);
        for(int i=0; i<columns.size(); i++) {
            results.add(hash.get(columns.get(i)));
        }
        return results;
    }

    private class Node {
        private TreeNode key;
        private Integer value;

        public Node(TreeNode key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

}
