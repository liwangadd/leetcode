package leetcode;

public class T1803 {

    private static final int HIGH_BIT = 14;

    public int countPairs(int[] nums, int low, int high) {
        return leCount(nums, high) - leCount(nums, low - 1);
    }

    private int leCount(int[] nums, int ceiling) {
        Tree root = new Tree();
        int res = 0;
        for (int i = 1, len = nums.length; i < len; ++i) {
            add(root, nums[i - 1]);
            res += get(root, nums[i], ceiling);
        }
        return res;
    }

    private void add(Tree node, int num) {
        for (int i = HIGH_BIT; i >= 0; --i) {
            int bit = (num >>> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new Tree();
            }
            node = node.children[bit];
            ++node.count;
        }
    }

    private int get(Tree node, int num, int ceiling) {
        int sum = 0;
        for (int i = HIGH_BIT; i >= 0; --i) {
            int bit = (num >>> i) & 1;
            if (((ceiling >>> i) & 1) == 1) {
                if (node.children[bit] != null) {
                    sum += node.children[bit].count;
                }
                if (node.children[bit ^ 1] == null) {
                    return sum;
                }
                node = node.children[bit ^ 1];
            } else {
                if (node.children[bit] == null) {
                    return sum;
                }
                node = node.children[bit];
            }
        }
        sum += node.count;
        return sum;
    }

    private static class Tree {

        private Tree[] children;

        private int count;

        public Tree() {
            this.children = new Tree[2];
            this.count = 0;
        }
    }

}
