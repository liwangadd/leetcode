package leetcode.T1_T100;

public class T8 {

    private int myAtoi(String str) {
        char[] arr = str.toCharArray();
        long out = 0;
        int i = 0;
        boolean minus = false;
        while (i < arr.length && (arr[i] == ' ')) {
            i++;
        }
        if (i >= arr.length) {
            return 0;
        }
        if (arr[i] == '-') {
            minus = true;
            i++;
        } else if (arr[i] == '+') {
            i++;
        }
        while (i < arr.length && arr[i] == '0') {
            i++;
        }
        int j = i;
        for (; j < Math.min(i + 11, arr.length); j++) {
            if ((arr[j] >= '0' && arr[j] <= '9')) {
                out = out * 10 + arr[j] - '0';
            } else {
                break;
            }
        }
        if (minus) {
            out = 0 - out;
        }
        if (out > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (out < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) out;
    }

    public int myAtoi2(String str) {
        int index = 0, sign = 1, total = 0;
        char[] sArr = str.toCharArray();
        while (index < sArr.length && sArr[index] == ' ') ++index;
        if (index < sArr.length && (sArr[index] == '-' || sArr[index] == '+')) {
            if(sArr[index] == '-')
                sign = -1;
            ++index;
        }
        while (index < str.length()) {
            char c = sArr[index];
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit)) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                total = total * 10 + digit;
            } else {
                break;
            }
            ++index;
        }
        return sign * total;
    }

    public static void main(String[] args) {
        T8 solution = new T8();
        System.out.println(solution.myAtoi("   "));
        System.out.println(solution.myAtoi("        -42"));
        System.out.println(solution.myAtoi("4139 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
    }

}
