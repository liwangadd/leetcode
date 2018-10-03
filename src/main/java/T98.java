import java.util.LinkedList;
import java.util.List;

public class T98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i + 1) <= list.get(i)) return false;
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
