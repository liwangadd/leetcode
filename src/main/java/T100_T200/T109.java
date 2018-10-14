package T100_T200;

import utils.ListNode;
import utils.TreeNode;

public class T109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head, slow = head;
        while (fast != tail) {
            fast = fast.next;
            if (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head, slow);
        node.right = sortedListToBST(slow.next, tail);
        return node;
    }

}
