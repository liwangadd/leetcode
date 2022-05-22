package leetcode.T500_T600;

import java.security.PrivateKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T525 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int zeroCount = 0, oneCount = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) ++zeroCount;
            else if (nums[i] == 1) ++oneCount;
            if (zeroCount == oneCount) {
                maxLength = Math.max(maxLength, i + 1);
                continue;
            }
            int diff = oneCount - zeroCount;
            if (map.containsKey(diff)) {
                maxLength = Math.max(maxLength, i - map.get(diff));
            }else{
                map.put(diff, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,1,0,1,1,1,0,0,1,0,0,1,0,1,0,1,0,1,0,0,1,1};
        System.out.println(nums.length);
        System.out.println(Arrays.stream(nums).filter(i->i==0).count());
        System.out.println(new T525().findMaxLength(nums));
    }

}
