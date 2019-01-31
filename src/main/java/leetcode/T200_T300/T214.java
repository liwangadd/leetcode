package leetcode.T200_T300;

public class T214 {

    public String shortestPalindrome(String s) {
        String tmp = s + "#" + new StringBuilder(s).reverse();
        int[] table = buildTable(tmp);
        return new StringBuilder(s.substring(table[table.length - 1] + 1)).reverse().toString() + s;
    }

    private int[] buildTable(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        int last = -1, i = 0;
        while (i < str.length() - 1) {
            if (last == -1 || str.charAt(i) == str.charAt(last)) {
                next[++i] = ++last;
            } else {
                last = next[last];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        T214 solution = new T214();
        System.out.println(solution.shortestPalindrome("abcd"));
    }

//    private int[] buildTable(String tmp) {
//        int[] table = new int[tmp.length()];
//        int index = 0;
//        char[] tmpArr = tmp.toCharArray();
//        for (int i = 1, len = tmp.length(); i < len; ++i) {
//            if (tmpArr[i] == tmpArr[index]) {
//                table[i] = table[i - 1] + 1;
//                ++index;
//            } else {
//                index = table[i - 1];
//                while (index > 0 && tmpArr[index] != tmpArr[i])
//                    index = table[index - 1];
//                table[i] = index += tmpArr[index] == tmpArr[i] ? 1 : 0;
//            }
//        }
//        return table;
//    }

}
