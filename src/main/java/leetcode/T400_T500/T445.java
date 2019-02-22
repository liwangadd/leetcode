package leetcode.T400_T500;

import utils.ListNode;

import java.util.Stack;

public class T445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.val == 0) return l2;
        if (l2 == null || l2.val == 0) return l1;
        Stack<Integer> num1 = new Stack<>(), num2 = new Stack<>();
        ListNode node = l1;
        while (node != null) {
            num1.push(node.val);
            node = node.next;
        }
        node = l2;
        while (node != null) {
            num2.push(node.val);
            node = node.next;
        }

        int res = 0, carry = 0;
        ListNode head = null;
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int n1 = num1.isEmpty() ? 0 : num1.pop();
            int n2 = num2.isEmpty() ? 0 : num2.pop();
            res = n1 + n2 + carry;
            node = new ListNode(res % 10);
            node.next = head;
            head = node;
            carry = res / 10;
        }
        if (carry != 0) {
            node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;
    }

}
