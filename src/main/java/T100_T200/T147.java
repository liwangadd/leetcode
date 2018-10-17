package T100_T200;

import utils.ListNode;

public class T147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;

        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;

            while (pre.next != null && pre.next.val < cur.val)
                pre = pre.next;

            cur.next = pre.next;
            pre.next = cur;
            pre = newHead;
            cur = next;
        }

        return newHead.next;
    }

}
