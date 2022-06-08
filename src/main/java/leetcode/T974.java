package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T974 {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += map.getOrDefault(((sum - k) % k + k) % k, 0);
            int mod = (sum % k + k) % k;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new T974().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println(res);
    }

}
