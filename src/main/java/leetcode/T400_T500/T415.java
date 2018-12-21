package leetcode.T400_T500;

public class T415 {

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i > -1 || j > -1; --i, --j) {
            int n1 = i > -1 ? num1.charAt(i) - '0' : 0;
            int n2 = j > -1 ? num2.charAt(j) - '0' : 0;
            int res = n1 + n2 + carry;
            sb.append(res % 10);
            carry = res / 10;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("987654321", "12345679"));
    }

}
