package leetcode.T1_T100;

public class T9 {

    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x==rev || rev / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12111));
    }

}
