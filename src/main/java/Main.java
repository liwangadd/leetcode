import java.util.HashMap;
import java.util.Map;

public class Main {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> existed = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (existed.containsKey(target - nums[i])) return new int[]{existed.get(target - nums[i]), i};
            existed.put(nums[i], i);
        }
        return new int[0];
    }

}

