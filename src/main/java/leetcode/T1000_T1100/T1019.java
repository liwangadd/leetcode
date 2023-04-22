package leetcode.T1000_T1100;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class T1019 {

    public int[] nextLargerNodes(ListNode head) {
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) ++count;
        int[] res = new int[count];
        Deque<int[]> stack = new LinkedList<>();
        int index = 0;
        for (ListNode node = head; node != null; node = node.next, ++index) {
            while (!stack.isEmpty() && node.val > stack.peek()[0]) {
                res[stack.pop()[1]] = node.val;
            }
            stack.push(new int[]{node.val, index});
        }
        return res;
    }

}
