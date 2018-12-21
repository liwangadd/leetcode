package leetcode.T100_T200;

import leetcode.utils.ListNode;

public class T148 {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);

    }

    private static ListNode merge(ListNode first, ListNode second) {

        ListNode head = new ListNode(0);
        ListNode current = head;
        while (first != null && second != null) {
            if (first.val < second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        current.next= first == null ? second : first;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = sortList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
