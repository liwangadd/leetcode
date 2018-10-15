package T1_T100;

import utils.ListNode;

public class T19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode current1 = newHead, current2 = newHead;
        while (n-- != 0) {
            current1 = current1.next;
        }
        while (current1.next != null) {
            current2 = current2.next;
            current1 = current1.next;
        }
        current2.next = current2.next.next;
        return newHead.next;
    }

}
