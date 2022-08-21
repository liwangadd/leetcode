package leetcode;

import java.util.LinkedList;
import java.util.Objects;

public class T1696 {

    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> maxStack = new LinkedList<>();
        for (int num : nums) {
            int sum = (maxStack.isEmpty() ? 0 : maxStack.getFirst()) + num;
            stack.add(sum);
            while (!maxStack.isEmpty() && maxStack.getLast() < sum) maxStack.removeLast();
            maxStack.addLast(sum);
            if (stack.size() > k) {
                Integer removed = stack.removeFirst();
                if (Objects.equals(removed, maxStack.getFirst())) maxStack.removeFirst();
            }
        }
        return stack.getLast();
    }

    public static void main(String[] args) {
        int res = new T1696().maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2);
        System.out.println(res);
    }

}
