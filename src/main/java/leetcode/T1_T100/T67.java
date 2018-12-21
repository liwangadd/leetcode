package leetcode.T1_T100;

public class T67 {

    private static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int flag = 0;
        StringBuilder sb = new StringBuilder(Math.max(a.length(), b.length()));
        for (; i >= 0 || j >= 0; i--, j--) {
            int current;
            if (i < 0) {
                current = b.charAt(j) - '0' + flag;
            } else if (j < 0) {
                current = a.charAt(i) - '0' + flag;
            } else {
                current = a.charAt(i) + b.charAt(j) - '0' * 2 + flag;
            }
            sb.append((char) (current % 2 + '0'));
            flag = current / 2;
        }
        if (flag != 0) sb.append((char) (flag + '0'));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("", ""));
    }

}
