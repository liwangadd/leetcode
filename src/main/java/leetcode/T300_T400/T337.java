package leetcode.T300_T400;

import utils.TreeNode;

import java.io.Serializable;

public class T337 implements Serializable{

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode node) {
        if (node == null) return new int[2];
        int[] res1 = robSub(node.left);
        int[] res2 = robSub(node.right);
        int[] res = new int[2];
        res[0] = Math.max(res1[0], res1[1]) + Math.max(res2[0], res2[1]);
        res[1] = node.val + res1[0] + res2[0];
        return res;
    }

    public void test(){
        System.out.println(getClass().getGenericSuperclass());
    }

    public static void main(String[] args) {
        T337 solution = new T337();
        solution.test();
    }
}
