package leetcode;

import sun.util.resources.cldr.my.CurrencyNames_my;
import utils.ListNode;
import utils.NestedInteger;
import utils.TreeNode;

import java.util.*;

public class Second {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;
        String tmp = s + "#" + new StringBuilder(s).reverse();
        int[] next = buildNext(tmp);
        return new StringBuilder(s.substring(next[tmp.length() - 1])).reverse() + s;
    }

    private int[] buildNext(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        int slow = 0;
        for (int fast = 1; fast < str.length(); ++fast) {
            while (slow > 0 && str.charAt(slow) != str.charAt(fast)) slow = next[slow - 1];
            next[fast] = (slow += str.charAt(slow) == str.charAt(fast) ? 1 : 0);
        }
        // int slow = -1, fast = 0;
        // while (fast < str.length() - 1) {
        //     if (slow == -1 || str.charAt(slow) == str.charAt(fast)) {
        //         next[++fast] = ++slow;
        //     } else {
        //         slow = next[slow];
        //     }
        // }
        return next;
    }

    public static void main(String[] args) {
        Second solution = new Second();
        for (int pos : solution.buildNext("aacecaaa")) {
            System.out.print(pos + " ");
        }
//        solution.add();
//        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
//        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
//        for (int num : solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)) {
//            System.out.println(num);
//        }
    }

}
