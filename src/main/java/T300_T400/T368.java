package T300_T400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;

        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n], idx = new int[n];
        int maxLength = 0, id = 0;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            idx[i] = -1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    idx[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                id = i;
            }
        }
        while (idx[id] != -1) {
            res.add(nums[id]);
            id = idx[id];
        }
        res.add(nums[id]);

        return res;
    }

    public static void main(String[] args) {
        T368 solution = new T368();
        for (Integer item : solution.largestDivisibleSubset(new int[]{1, 2, 4, 8})) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
