public class T234 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode current = head;
        int size = 0, mid;
        while (current != null) {
            ++size;
            current = current.next;
        }
        mid = size / 2;
        current = head;
        int[] stack = new int[size / 2];
        for (int i = 0; i < mid; ++i) {
            stack[i] = current.val;
            current = current.next;
        }
        if (size % 2 != 0) current = current.next;
        for (int i = mid - 1; i > -1; --i) {
            if (stack[i] != current.val) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

}
