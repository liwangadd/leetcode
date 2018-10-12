package T200_T300;

public class T203 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode last = new ListNode(-1);
        last.next = head;
        ListNode newHead = last;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                current = current.next;
            } else {
                last.next = current;
                current = current.next;
                last = last.next;
            }
        }
        last.next = null;
        return newHead.next;
    }
}
