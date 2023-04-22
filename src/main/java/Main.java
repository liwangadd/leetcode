import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static class Tuple {

        private TreeNode node;
        private int index;

        public Tuple(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 1));
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(), startIndex = queue.peek().index, endIndex = startIndex;
            while (size-- > 0) {
                Tuple tuple = queue.poll();
                endIndex = tuple.index;
                if (tuple.node.left != null) {
                    queue.add(new Tuple(tuple.node.left, tuple.index * 2 - 1));
                }
                if (tuple.node.right != null) {
                    queue.add(new Tuple(tuple.node.right, tuple.index * 2));
                }
            }
            res = Math.max(res, endIndex - startIndex + 1);
        }
        return res;
    }

}

