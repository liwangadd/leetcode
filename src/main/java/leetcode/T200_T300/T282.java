package leetcode.T200_T300;

import java.util.LinkedList;
import java.util.List;

public class T282 {

    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        if (num.length() == 0) return res;

        for (int i = 1; i <= num.length(); ++i) {
            String val = num.substring(0, i);
            helper(num.substring(i), val, 0, Long.valueOf(val), target, res);
            if (num.charAt(0) == '0') break;
        }
        return res;
    }

    private void helper(String num, String path, long subTarget, long last, int target, List<String> res) {
        if (num.length() == 0 && subTarget + last == target) {
            res.add(path);
        }
        for (int i = 1; i <= num.length(); ++i) {
            long val = Long.valueOf(num.substring(0, i));
            String nextNum = num.substring(i);
            helper(nextNum, path + "+" + val, subTarget + last, val, target, res);
            helper(nextNum, path + "-" + val, subTarget + last, -val, target, res);
            helper(nextNum, path + "*" + val, subTarget, val * last, target, res);
            if (num.charAt(0) == '0') break;
        }
    }

    public static void main(String[] args) {
        T282 solution = new T282();
        for (String item : solution.addOperators("232", 8)) {
            System.out.println(item);
        }
        System.out.println();
        for (String item : solution.addOperators("123", 6)) {
            System.out.println(item);
        }
        System.out.println();
        for (String item : solution.addOperators("105", 5)) {
            System.out.println(item);
        }

        System.out.println();
        for (String item : solution.addOperators("00", 0)) {
            System.out.println(item);
        }

        System.out.println();
        for (String item : solution.addOperators("3456237490", 9191)) {
            System.out.println(item);
        }
    }

}
