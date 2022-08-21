import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int num : nums) {
            if (num <= target)
                dp[num] = 1;
        }
        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                dp[i] += i - num > 0 ? dp[i - num] : 0;
            }
        }
        return dp[target];
    }

}

