package leetcode.T300_T400;

public class T345 {

    public static String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char lowChar = sb.charAt(low);
            char highChar = sb.charAt(high);
            while (!isVewel(lowChar) && low < high) {
                lowChar = sb.charAt(++low);
            }
            while (!isVewel(highChar) && low < high) {
                highChar = sb.charAt(--high);
            }
            sb.setCharAt(low++, highChar);
            sb.setCharAt(high--, lowChar);
        }
        return sb.toString();
    }

    private static boolean isVewel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

}
