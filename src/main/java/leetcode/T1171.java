package leetcode;

import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

public class T1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        map.put(0, dummy);
        int sum = 0;
        ListNode node = head;
        while (node != null) {
            sum += node.val;
            map.put(sum, node);
            node = node.next;
        }
        sum = 0;
        node = dummy;
        while (node != null) {
            sum += node.val;
            if (map.containsKey(sum)) {
                node.next = map.get(sum).next;
            }
            node = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(-3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(1);
        new T1171().removeZeroSumSublists(node);
    }

}
