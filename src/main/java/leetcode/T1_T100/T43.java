package leetcode.T1_T100;

public class T43 {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num2.length(); ++i) {
            StringBuilder sbTmp = new StringBuilder();
            int carry = 0;
            int multi1 = (num2.charAt(num2.length() - i - 1) - '0');
            for (int j = num1.length() - 1; j > -1; --j) {
                int res = (num1.charAt(j) - '0') * multi1 + carry;
                sbTmp.append(res % 10);
                carry = res / 10;
            }
            if (carry != 0) {
                sbTmp.append(carry);
                carry = 0;
            }
            for (int k = i, m = 0; k < sb.length() || m < sbTmp.length(); ++k, ++m) {
                int n1 = 0, n2 = 0;
                if (k < sb.length()) {
                    n1 = sb.charAt(k) - '0';
                }
                if (m < sbTmp.length()) {
                    n2 = sbTmp.charAt(m) - '0';
                }
                int res = n1 + n2 + carry;
                if (k < sb.length()) {
                    sb.setCharAt(k, (char) ('0' + res % 10));
                } else {
                    sb.append(res % 10);
                }
                carry = res / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(multiply("2", "2"));
        System.out.println(multiply("123", "456"));
    }

}
