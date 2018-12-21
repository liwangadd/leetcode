package leetcode.T1_T100;

import leetcode.utils.ListNode;

public class T86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode lessHead = new ListNode(1);
        ListNode greaterHead = new ListNode(1);
        ListNode lessCurrent = lessHead, greaterCurrent = greaterHead;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                lessCurrent.next = current;
                lessCurrent = lessCurrent.next;
            } else {
                greaterCurrent.next = current;
                greaterCurrent = greaterCurrent.next;
            }
            current = current.next;
        }
        greaterCurrent.next = null;
        lessCurrent.next = greaterHead.next;
        return lessHead.next;
    }

}
