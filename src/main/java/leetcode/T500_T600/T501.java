package leetcode.T500_T600;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T501 {

    private List<Integer> arr;
    private int mostFreq = 1;

    public int[] findMode(TreeNode root) {
        arr = new ArrayList<>();
        findFreq(root);
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); ++i) {
            res[i] = arr.get(i);
        }
        return res;
    }

    private void findFreq(TreeNode node) {
        if (node == null) return;
        int freq = countVal(node, node.val);
        if (freq > mostFreq) {
            arr.clear();
            arr.add(node.val);
            mostFreq = freq;
        } else if (freq == mostFreq) {
            arr.add(node.val);
        }
        findFreq(node.left);
        findFreq(node.right);
    }

    private int countVal(TreeNode node, int val) {
        if (node == null) return 0;
        return (node.val == val ? 1 : 0) + countVal(node.left, val) + countVal(node.right, val);
    }

    public static void main(String[] args) {
        T501 solution=new T501();
        TreeNode root = new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left = new TreeNode(2);
        for (int node : solution.findMode(root)) {
            System.out.print(node + " ");
        }
    }

}
