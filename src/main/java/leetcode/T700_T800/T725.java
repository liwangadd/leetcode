package leetcode.T700_T800;

import utils.ListNode;

import java.util.LinkedList;
import java.util.List;

public class T725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode node = head, nextHead = null;
        while (node != null) {
            ++len;
            node = node.next;
        }
        int longerCount = len % k, shorterCount = k - longerCount;
        int longerLen = len / k + 1, shorterLen = len / k;
        List<ListNode> res = new LinkedList<>();
        node = head;
        while (node != null) {
            len = 1;
            int partLen = longerCount > 0 ? longerLen : shorterLen;
            ListNode partHead = node;
            while (node != null && len < partLen) {
                ++len;
                node = node.next;
            }
            if (partLen == longerLen) --longerCount;
            else --shorterCount;
            nextHead = null;
            if (node != null) {
                nextHead = node.next;
                node.next = null;
            }
            res.add(partHead);
            node = nextHead;
        }
        while (res.size() < k) res.add(null);
        return res.toArray(new ListNode[0]);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node = root;
        for (int i = 0; i < 9; i++) {
            node.next = new ListNode(node.val + 1);
            node = node.next;
        }
        new T725().splitListToParts(root, 3);
    }

}
