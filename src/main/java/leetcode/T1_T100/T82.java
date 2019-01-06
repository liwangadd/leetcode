package leetcode.T1_T100;

import utils.ListNode;

public class T82 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = new ListNode(-1);
        ListNode newHead = pre;
        ListNode current = head.next;
        ListNode oneNode = head;
        int count = 1;
        while (current != null) {
            if (current.val != oneNode.val) {
                if (count == 1) {
                    pre.next = oneNode;
                    pre = pre.next;
                }
                oneNode = current;
                count = 1;
            } else {
                ++count;
            }
            current = current.next;
        }
        if (count == 1) pre.next = oneNode;
        else pre.next = null;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(4);
        ListNode newHead = deleteDuplicates(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
