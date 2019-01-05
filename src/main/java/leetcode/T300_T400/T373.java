package leetcode.T300_T400;

import java.util.ArrayList;
import java.util.List;

public class T373 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || k <= 0 || nums2 == null || nums2.length == 0) return res;

        int[] indexes = new int[nums1.length];
        while (k-- != 0) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            boolean changed = false;
            for (int i = 0, len = nums1.length; i < len; ++i) {
                if (indexes[i] != nums2.length) {
                    if (nums1[i] + nums2[indexes[i]] < min) {
                        min = nums1[i] + nums2[indexes[i]];
                        minIndex = i;
                        changed = true;
                    }
                }
            }
            if (!changed) break;
            indexes[minIndex] = indexes[minIndex] + 1;
            res.add(new int[]{nums1[minIndex], min - nums1[minIndex]});
        }

        return res;
    }

    public static void main(String[] args) {
        T373 solution = new T373();
        List<int[]> res = solution.kSmallestPairs(new int[]{1, 2, 4}, new int[]{-1, 1, 2}, 100);
        for (int[] re : res) {
            System.out.println(re[0] + "," + re[1]);
        }
    }

}
