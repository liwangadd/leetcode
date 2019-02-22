package leetcode.T400_T500;

public class T421 {

    private class Node {

        private Node[] children;

        public Node() {
            children = new Node[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Node root = new Node(), cur = root;
        for (int num : nums) {
            for (int i = 31; i >= 0; --i) {
                int bit = (num >>> i & 1);
                if (cur.children[bit] == null) cur.children[bit] = new Node();
                cur = cur.children[bit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            cur = root;
            int localMax = 0;
            for (int i = 31; i >= 0; --i) {
                int bit = (num >>> i & 1);
                if (cur.children[bit ^ 1] != null) {
                    cur = cur.children[bit ^ 1];
                    localMax <<= 1;
                    localMax |= 1;
                } else {
                    localMax <<= 1;
                    cur = cur.children[bit];
                }
            }
            max=Math.max(max, localMax);
        }
        return max;
    }

}
