package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T2465 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        Set<Integer> diffCounter = new HashSet<>();
        while (left < right) {
            int sum = nums[left++] + nums[right--];
            diffCounter.add(sum);
        }
        return diffCounter.size();
    }

}
