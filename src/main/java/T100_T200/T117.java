package T100_T200;

import java.util.LinkedList;
import java.util.Queue;

public class T117 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            TreeLinkNode preNode = queue.poll();
            --count;
            if (preNode.left != null) queue.add(preNode.left);
            if (preNode.right != null) queue.add(preNode.right);
            if (count > 0) preNode.next = queue.peek();
            else count = queue.size();
        }
    }

}
