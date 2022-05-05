package leetcode.T300_T400;

import utils.ListNode;

import java.util.Random;

public class T382 {

    private class Solution {

        private ListNode head;
        private Random random;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            ListNode cur = this.head;
            int res = cur.val;
            for (int i = 1; cur.next != null; ++i) {
                cur = cur.next;
                if (random.nextInt(i + 1) == i) res = cur.val;
            }
            return res;
        }
    }
}
