package leetcode.T1_T100;

import leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T23 {

    public T23() {
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> array = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                array.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(array);
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for (Integer item : array) {
            current.next = new ListNode(item);
            current = current.next;
        }
        current.next = null;
        return head.next;
    }
}
