package leetcode.T200_T300;

import utils.ListNode;

public class T206 {

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
