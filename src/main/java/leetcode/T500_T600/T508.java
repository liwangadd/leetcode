package leetcode.T500_T600;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class T508 {

    private Map<Integer, Integer> map;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        map = new HashMap<>();
        findFreq(root);
        int mostFreq = 0, count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mostFreq) {
                mostFreq = entry.getValue();
                count = 1;
            } else if (entry.getValue() == mostFreq) ++count;
        }
        int[] res = new int[count];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mostFreq) res[index++] = entry.getKey();
        }
        return res;
    }

    private int findFreq(TreeNode node) {
        int sumLeft = 0, sumRight = 0;
        if (node.left != null) sumLeft = findFreq(node.left);
        if (node.right != null) sumRight = findFreq(node.right);
        map.put(node.val + sumLeft + sumRight, map.getOrDefault(node.val + sumLeft + sumRight, 0) + 1);
        return node.val + sumLeft + sumRight;
    }

}
