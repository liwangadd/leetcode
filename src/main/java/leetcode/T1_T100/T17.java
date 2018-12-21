package leetcode.T1_T100;

import java.util.LinkedList;
import java.util.List;

public class T17 {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new LinkedList<>();
        }
        String[][] array = new String[][]{{}, {}, {"a", "b", "c"}, {"d", "e", "f"},
                {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"},
                {"w", "x", "y", "z"}};
        List<String> res = new LinkedList<>();
        generate(array, digits, "", res);
        return res;
    }

    public static void generate(String[][] array, String digits, String lastStr, List<String> res) {
        if (digits.length() == 0) {
            res.add(lastStr);
        } else {
            for (String str : array[digits.charAt(0) - '0']) {
                generate(array, digits.substring(1), lastStr + str, res);
            }
        }
    }

    public static void main(String[] args) {
        for (String str : letterCombinations("23")) {
            System.out.println(str);
        }
    }

}
