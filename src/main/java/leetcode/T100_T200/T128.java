package leetcode.T100_T200;

import java.util.HashSet;
import java.util.Set;

public class T128 {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int length = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int currentLength = 1;
                while (set.contains(current + 1)) {
                    current++;
                    currentLength++;
                }
                length = Math.max(length, currentLength);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

}
