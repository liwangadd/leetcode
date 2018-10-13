package T200_T300;

import sun.awt.ScrollPaneWheelScroller;

public class T206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode first = null, second = head, nextHead = head.next;
        while (nextHead != null) {
            second.next = first;
            first = second;
            second = nextHead;
            nextHead = nextHead.next;
        }
        second.next = first;
        return second;
    }

}
