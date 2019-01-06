package leetcode.T100_T200;

import utils.ListNode;

public class T160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA, currentB = headB;
        int lengthA = 0, lengthB = 0;
        while (currentA != null) {
            currentA = currentA.next;
            ++lengthA;
        }
        while (currentB != null) {
            ++lengthB;
            currentB = currentB.next;
        }
        currentA = headA;
        currentB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; ++i) {
                currentA = currentA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; ++i) {
                currentB = currentB.next;
            }
        }
        while (currentA != null && currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return currentA;
    }
}
