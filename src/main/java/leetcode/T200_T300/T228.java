package leetcode.T200_T300;

import java.util.LinkedList;
import java.util.List;

public class T228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) return res;
        StringBuilder sb = new StringBuilder();

        sb.append(nums[0]);
        int last = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] + 1) {
                if (last != nums[i - 1])
                    sb.append("->").append(nums[i - 1]);
                res.add(sb.toString());
                sb = new StringBuilder();
                last = nums[i];
                sb.append(nums[i]);
            }
        }
        if (last != nums[nums.length - 1]) {
            sb.append("->").append(nums[nums.length - 1]);
        }
        res.add(sb.toString());
        return res;
    }

    public static void main(String[] args) {
        T228 solution = new T228();
        for (String s : solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})) {
            System.out.println(s);
        }
    }

}
