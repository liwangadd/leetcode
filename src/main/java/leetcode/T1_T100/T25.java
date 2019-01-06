package leetcode.T1_T100;

import utils.ListNode;

public class T25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev != null) {
            prev = reverseK(prev, k);
        }

        return dummy.next;
    }

    private static ListNode reverseK(ListNode prev, int k) {
        ListNode n1 = prev.next;

        ListNode nk = prev;
        for (int i = 0; i < k; i++) {
            nk = nk.next;
            if (nk == null) {
                return null;
            }
        }

        ListNode nkp1 = nk.next;

        ListNode p = n1;
        ListNode cur = n1.next;
        while (p != nk) {
            ListNode next = cur.next;
            cur.next = p;
            p = cur;
            cur = next;
        }

        prev.next = nk;
        n1.next = nkp1;

        return n1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = reverseKGroup(head, 4);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
