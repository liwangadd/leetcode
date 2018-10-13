package T100_T200;

import utils.ListNode;

public class T141 {

    public boolean hasCycle(ListNode head) {
        ListNode current1 = head, current2 = head;
        while (current1 != null && current2 != null) {
            current1 = current1.next;
            current2 = current2.next;
            if (current2 != null) {
                current2 = current2.next;
            } else {
                return false;
            }
            if (current1 == current2) return true;
        }
        return false;
    }
}
