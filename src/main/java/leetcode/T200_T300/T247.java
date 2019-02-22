package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T247 {

    private List<String> result;
    private List<Character> same = Arrays.asList('0', '1', '8');
    private List<char[]> rotate = Arrays.asList(new char[]{'0', '0'}, new char[]{'1', '1'},
            new char[]{'6', '9'}, new char[]{'8', '8'}, new char[]{'9', '6'});

    public List<String> findStrobogrammatic(int n) {
        result = new ArrayList<>();
        if ((n & 1) == 0) {
            helper(n, "");
        } else {
            for (Character c : same) {
                helper(n - 1, String.valueOf(c));
            }
        }
        return result;
    }

    private void helper(int n, String str) {
        if (n == 0) {
            result.add(str);
            return;
        }
        for (int i = n == 2 ? 1 : 0; i < rotate.size(); ++i) {
            helper(n - 2, rotate.get(i)[0] + str + rotate.get(i)[1]);
        }
    }

    public static void main(String[] args) {
        T247 solution = new T247();
        for (String s : solution.findStrobogrammatic(1)) {
            System.out.println(s);
        }
    }
}
