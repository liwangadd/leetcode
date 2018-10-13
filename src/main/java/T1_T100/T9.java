package T1_T100;

public class T9 {

    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12111));
    }

}
