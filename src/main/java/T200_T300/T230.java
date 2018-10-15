package T200_T300;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class T230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
