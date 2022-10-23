package leetcode.T800_T900;

import utils.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.CheckedOutputStream;

public class T817 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int count = 0;
        boolean prevExist = false;
        while (head != null) {
            if (numSet.contains(head.val)) {
                if (!prevExist) ++count;
                prevExist = true;
            } else {
                prevExist = false;
            }
            head = head.next;
        }
        return count;
    }

}
