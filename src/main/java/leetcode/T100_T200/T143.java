package leetcode.T100_T200;

import utils.ListNode;

import java.util.Stack;

public class T143 {

    public void reorderList(ListNode head) {
        if(head==null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;
        while (slow != null) {
            stack.add(slow);
            slow = slow.next;
        }

        fast = head;
        while (!stack.isEmpty()) {
            slow = fast.next;
            fast.next = stack.pop();
            fast.next.next = slow;
            fast = slow;
        }
    }

}
