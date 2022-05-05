package leetcode.T100_T200;

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
        TreeLinkNode pre = null, nextHead = null, cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (pre == null) {
                        pre = cur.left;
                        nextHead = cur.left;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    if (pre == null) {
                        pre = cur.right;
                        nextHead = cur.right;
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            cur = nextHead;
            pre = null;
            nextHead = null;
        }
    }

}
