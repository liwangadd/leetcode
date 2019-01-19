package leetcode.T400_T500;

import java.util.ArrayList;
import java.util.List;

public class T442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0, len = nums.length; i < len; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        T442 solution = new T442();
        for (Integer num : solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})) {
            System.out.println(num);
        }
    }

}
