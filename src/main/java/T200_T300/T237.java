package T200_T300;

import utils.ListNode;

public class T237 {

    public static void deleteNode(ListNode node) {
        ListNode last = node;
        while (node.next != null) {
            node.val = node.next.val;
            last = node;
            node = node.next;
        }
        last.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        deleteNode(head.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
