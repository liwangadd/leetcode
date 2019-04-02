package leetcode.T300_T400;

import java.util.*;

public class T315 {

    class FenwickTree {
        private int[] sums;

        private int lowbit(int x) {
            return x & (-x);
        }

        public FenwickTree(int n) {
            sums = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < sums.length) {
                sums[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += sums[i];
                i -= lowbit(i);
            }
            return sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < sorted.length; ++i)
            if (i == 0 || sorted[i] != sorted[i - 1]) ranks.put(sorted[i], ++rank);

        FenwickTree tree = new FenwickTree(ranks.size());
        List<Integer> res = new ArrayList<>(ranks.size());
        for (int i = nums.length - 1; i >= 0; --i) {
            res.add(tree.query(ranks.get(nums[i]) - 1));
            tree.update(ranks.get(nums[i]), 1);
        }
        Collections.reverse(res);
        return res;
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    private class Node {
        private Node left, right;
        private int val, sum, dup = 1;

        public Node(int val, int sum) {
            this.val = val;
            this.sum = sum;
        }
    }

    public List<Integer> countSmaller2(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; --i) {
            root = buildTree(root, nums[i], ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private Node buildTree(Node node, int num, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = buildTree(node.left, num, ans, i, preSum);
        } else {
            node.right = buildTree(node.right, num, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }

}
