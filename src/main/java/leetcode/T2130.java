package leetcode;

import utils.ListNode;

import java.util.Stack;

public class T2130 {

    public int pairSum(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode fastNode = head, slowNode = head;
        while (fastNode != null) {
            fastNode = fastNode.next;
            if (fastNode == null) break;
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        while (slowNode != null) {
            stack.add(slowNode);
            slowNode = slowNode.next;
        }
        ListNode node = head;
        int res = 0;
        while (!stack.isEmpty()) {
            res = Math.max(stack.pop().val + node.val, res);
            node = node.next;
        }
        return res;
    }

}
