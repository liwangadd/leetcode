public class T24 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next, newTail = head;
        ListNode firstNode;
        ListNode nextHead = head;
        while (nextHead != null) {
            firstNode = nextHead;
            if (firstNode.next != null) {
                nextHead = firstNode.next.next;
                firstNode.next.next = firstNode;
                newTail.next = firstNode.next;
                newTail = firstNode;
            } else {
                newTail.next = firstNode;
                newTail = firstNode;
                break;
            }
        }
        newTail.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);

        ListNode newHead = swapPairs(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
