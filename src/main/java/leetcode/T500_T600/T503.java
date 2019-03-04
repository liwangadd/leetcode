package leetcode.T500_T600;

import java.util.Arrays;
import java.util.Stack;

public class T503 {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums.length; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; ++i) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        T503 solution = new T503();
        for (int item : solution.nextGreaterElements(new int[]{1, 2, 1})) {
            System.out.println(item);
        }
    }

}
