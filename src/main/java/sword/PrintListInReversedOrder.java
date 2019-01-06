package sword;

import utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintListInReversedOrder {

    public List<Integer> printListReversingly_Iteratively(ListNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) return res;

        List<Integer> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.add(cur.val);
            cur = cur.next;
        }
        for (int i = stack.size() - 1; i >= 0; --i) {
            res.add(stack.get(i));
        }
        return res;
    }

    public List<Integer> printListReversingly_Recursively(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.addAll(printListReversingly_Recursively(head.next));
            res.add(head.val);
        }
        return res;
    }
}
