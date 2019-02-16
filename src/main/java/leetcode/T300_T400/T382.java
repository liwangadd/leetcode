package leetcode.T300_T400;

import utils.ListNode;

import java.util.Random;

public class T382 {

    private int count;
    private Random random;
    private ListNode head;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public T382(ListNode head) {
        random = new Random();
        this.head = head;
        ListNode node = head;
        while (node != null) {
            ++count;
            node = node.next;
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int post = random.nextInt(count);
        ListNode node = head;
        while (post-- != 0) {
            node = node.next;
        }
        return node.val;
    }
}
