package leetcode.T300_T400;

public class T307_2 {

    private static class FenwickTree {

        private int[] nums;

        private int[] tree;

        private FenwickTree(int[] nums) {
            this.nums = new int[nums.length + 1];
            this.tree = new int[nums.length + 1];
            for (int i = 1; i < nums.length; i++) {
                update(i, nums[i - 1]);
            }
        }

        private int lowBit(int pos) {
            return pos & (-pos);
        }

        public void update(int pos, int val) {
            int diff = val - nums[pos];
            nums[pos] = val;
            while (pos < tree.length) {
                tree[pos] += diff;
                pos += lowBit(pos);
            }
        }

        public int sum(int pos) {
            int res = 0;
            while (pos > 0) {
                res += tree[pos];
                pos -= lowBit(pos);
            }
            return res;
        }
    }

    private FenwickTree tree;

    public T307_2(int[] nums) {
        tree = new FenwickTree(nums);
    }

    public void update(int i, int val) {
        tree.update(i, val);
    }

    public int sumRange(int i, int j) {
        if (j < i) return 0;
        return tree.sum(j + 1) - tree.sum(i);
    }

    public static void main(String[] args) {
        new T307_2(new int[]{1,7,3,0,5,8,3,2,6,2,1,1,4,5});
    }

}
