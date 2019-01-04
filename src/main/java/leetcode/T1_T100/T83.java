package leetcode.T1_T100;

import utils.ListNode;

public class T83 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            while (nextNode != null && nextNode.val == current.val) {
                nextNode = nextNode.next;
            }
            current.next = nextNode;
            current = nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        ListNode resultNode = deleteDuplicates(head1);
        while (resultNode != null) {
            System.out.print(resultNode.val);
            resultNode = resultNode.next;
        }
        System.out.println();
    }

}
