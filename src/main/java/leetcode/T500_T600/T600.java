package leetcode.T500_T600;

public class T600 {

    public int findIntegers(int num) {
        String str = new StringBuilder(Integer.toBinaryString(num)).reverse().toString();
        int[] zero = new int[str.length()], one = new int[str.length()];
        zero[0] = one[0] = 1;
        for (int i = 1; i < str.length(); ++i) {
            zero[i] = zero[i - 1] + one[i - 1];
            one[i] = zero[i - 1];
        }
        int count = zero[str.length() - 1] + one[str.length() - 1];
        for (int i = str.length() - 2; i >= 0; --i) {
            if (str.charAt(i) == '1' && str.charAt(i + 1) == '1') break;
            if (str.charAt(i) == '0' && str.charAt(i - 1) == '0') count -= one[i];
        }
        return count;
    }

}
