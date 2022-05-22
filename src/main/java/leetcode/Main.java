package leetcode;


import java.util.Arrays;

public class Main {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 0, 0, sum / k, k);
    }

    private boolean helper(int[] nums, boolean[] visited, int startIndex, int curSum, int target, int count) {
        if (count == 1) return true;
        if (curSum > target) return false;
        if (curSum == target) return helper(nums, visited, 0, 0, target, count - 1);
        for (int i = startIndex; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                if (helper(nums, visited, i + 1, curSum + nums[i], target, count)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}