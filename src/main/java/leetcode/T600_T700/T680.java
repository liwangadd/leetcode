package leetcode.T600_T700;

public class T680 {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        int left = 0, right = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s.substring(left + 1, right + 1)) || isPalindrome(s.substring(left, right));
            }
            ++left;
            --right;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        char[] sArr = s.toCharArray();
        int left = 0, right = sArr.length - 1;
        while (left < right) {
            if (sArr[left++] != sArr[right--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        T680 solution = new T680();
        System.out.println(solution.validPalindrome("bddb"));
        System.out.println(solution.validPalindrome("abca"));
    }
}
