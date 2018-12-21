package leetcode.T1_T100;

public class T8 {

    private static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int i = 0;
        boolean flag = true;
        if (str.charAt(i) == '+') i++;
        else if (str.charAt(i) == '-') {
            i++;
            flag = false;
        }
        double result = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + str.charAt(i) - '0';
            i++;
        }
        if (!flag) result = -result;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int) result;
    }

}
