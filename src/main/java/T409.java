public class T409 {

    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] flags = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            flags[s.charAt(i)]++;
        }
        int length = 0;
        boolean flag = false;
        for (int i = 'A'; i <= 'z'; ++i) {
            length += 2 * (flags[i] / 2);
        }
        for (int i = 'A'; i <= 'z'; ++i) {
            if (flags[i] % 2 != 0) {
                flag = true;
                break;
            }
        }
        return flag ? length + 1 : length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }

}
