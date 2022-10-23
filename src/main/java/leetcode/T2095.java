package leetcode;

import utils.ListNode;

public class T2095 {

    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            ++count;
        }
        int middle = count / 2;
        node = new ListNode(-1);
        ListNode prevHead = node;
        node.next = head;
        while (middle-- > 0) {
            node = node.next;
        }
        node.next = node.next.next;
        return prevHead.next;
    }

}
