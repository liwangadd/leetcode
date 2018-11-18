package T300_T400;

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

}
