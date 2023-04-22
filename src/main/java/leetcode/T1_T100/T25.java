package leetcode.T1_T100;

import utils.ListNode;

public class T25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode node = dummyHead;
        while (true) {
            ListNode prevTail = node;
            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) break;
            ListNode nextHead = node.next;
            ListNode[] nodes = reverse(prevTail.next, node);
            prevTail.next = nodes[0];
            nodes[1].next = nextHead;
            node = nodes[1];
        }
        return dummyHead.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode node = head, prev = null, tailAfter = tail.next;
        do {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        } while (node != tailAfter);
        return new ListNode[]{tail, head};
    }

}
