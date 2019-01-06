package leetcode.T100_T200;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class T129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<Integer> integerList = new LinkedList<>();
        sumNumbers(root, 0, integerList);
        int res = 0;
        for (Integer integer : integerList) {
            res += integer;
        }
        return res;
    }

    private void sumNumbers(TreeNode node, int val, List<Integer> integerList) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            int res = val * 10 + node.val;
            integerList.add(res);
            return;
        }
        int curVal = val * 10 + node.val;
        sumNumbers(node.left, curVal, integerList);
        sumNumbers(node.right, curVal, integerList);
    }

}
