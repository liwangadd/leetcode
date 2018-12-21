package leetcode.T100_T200;

public class T125 {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int low = 0, high = s.length() - 1;
        while (low < high) {
            while (low < s.length() && !Character.isLetterOrDigit(s.charAt(low))) {
                ++low;
            }
            while (high >= 0 && !Character.isLetterOrDigit(s.charAt(high))){
                --high;
            }
            if (low >= high) return true;
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(".,"));
    }
}
