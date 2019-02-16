package leetcode.T300_T400;

import utils.ListNode;

public class T369 {

    public ListNode plusOne(ListNode head) {
        // Write your code here
        if (head == null) return head;
        int carry = helper(head);
        if (carry != 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    private int helper(ListNode node) {
        int val;
        if (node.next != null) {
            int carry = helper(node.next);
            val = node.val + carry;
        } else {
            val = node.val + 1;
        }
        node.val = val % 10;
        return val / 10;
    }

}
