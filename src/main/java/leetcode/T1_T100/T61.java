package leetcode.T1_T100;

import utils.ListNode;

public class T61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            ++length;
        }
        k %= length;
        if (k == 0) return head;

        ListNode fastNode = head;
        ListNode slowNode = head;
        while (k-- != 0) fastNode = fastNode.next;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        ListNode newHead = slowNode.next;
        slowNode.next = null;
        fastNode.next = head;
        return newHead;
    }
}
