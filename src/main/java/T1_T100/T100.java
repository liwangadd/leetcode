package T1_T100;

import java.util.Stack;

public class T100 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);
        while (!pStack.empty() && !qStack.empty()) {
            while (p != null && q != null) {
                if (p.val != q.val) return false;
                else {
                    p = p.left;
                    q = q.left;
                    pStack.push(p);
                    qStack.push(q);
                }
            }
            if (p != null || q != null) return false;
        }
        return pStack.empty() && qStack.empty();
    }

}
