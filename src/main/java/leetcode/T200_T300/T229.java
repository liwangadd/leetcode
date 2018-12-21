package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.List;

public class T229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int num1 = nums[0], num2 = nums[0];
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == num1) ++count1;
            else if (num == num2) ++count2;
            else if (count1 == 0) {
                num1 = num;
                count1 = 0;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 0;
            } else {
                --count1;
                --count2;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) ++count1;
            else if (num == num2) ++count2;
        }
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);
        return res;
    }

    public static void main(String[] args) {
        T229 solution = new T229();
        for (Integer item : solution.majorityElement(new int[]{1, 2, 1, 3, 4, 3})) {
            System.out.println(item);
        }
    }

}
