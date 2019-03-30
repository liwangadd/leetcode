package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.List;

public class T229 {

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        for (int num : nums) {
            if (num == number1)
                count1++;
            else if (num == number2)
                count2++;
            else if (count1 == 0) {
                number1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == number1)
                count1++;
            else if (num == number2)
                count2++;
        }
        if (count1 > len / 3)
            result.add(number1);
        if (count2 > len / 3)
            result.add(number2);
        return result;
    }

    public static void main(String[] args) {
        T229 solution = new T229();
        for (Integer item : solution.majorityElement(new int[]{1, 2, 1, 3, 4, 3})) {
            System.out.println(item);
        }
    }

}
