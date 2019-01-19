package leetcode.T300_T400;

import utils.ListNode;

public class T328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode evenNode = head.next.next;
        ListNode nextNode = head.next;

        ListNode evenTail = head;
        ListNode oddNode = head.next;
        while (evenNode != null) {
            oddNode.next = evenNode.next;
            oddNode = evenNode.next;
            evenTail.next = evenNode;
            evenNode.next = nextNode;
            evenTail = evenTail.next;
            if (oddNode != null) evenNode = oddNode.next;
            else break;
        }
        return head;
    }

    public static void main(String[] args) {
        T328 solution = new T328();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(5);
//        head.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(7);
        head = solution.oddEvenList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
