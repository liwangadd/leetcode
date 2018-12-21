package leetcode.T100_T200;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        pathSum(root, sum, res, new LinkedList<>());
        return res;
    }

    private void pathSum(TreeNode node, int sum, List<List<Integer>> res, List<Integer> resItem) {
        if (node.left == null && node.right == null) {
            if (sum - node.val == 0) {
                List<Integer> list = new ArrayList<>(resItem);
                list.add(node.val);
                res.add(list);
            } else {
                return;
            }
        }

        resItem.add(node.val);
        if (node.left != null) {
            pathSum(node.left, sum - node.val, res, resItem);
        }
        if (node.right != null) {
            pathSum(node.right, sum - node.val, res, resItem);
        }
        resItem.remove(resItem.size() - 1);
    }

}
