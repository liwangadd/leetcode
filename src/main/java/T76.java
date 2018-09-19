import java.util.Arrays;

public class T76 {

    private static String minWindow(String s, String t) {

        int minLength = s.length() + 1;
        String res = "";
        int left = 0, right = -1;
        int[] flags1 = new int[256], flags2 = new int[256];

        for (int i = 0; i < t.length(); ++i) {
            flags1[t.charAt(i)]++;
        }

        while (left < s.length()) {
            while (right < s.length() - 1 && (flags2[s.charAt(right + 1)] < flags1[s.charAt(right + 1)]
                    || flags1[s.charAt(right + 1)] == 0)) {
                if (flags1[s.charAt(++right)] != 0)
                    flags2[s.charAt(right)]++;
                if (right == s.length() - 1 && flags1[s.charAt(right)] == 0) break;
            }
            if (Arrays.equals(flags1, flags2)) {
                if (right - left + 1 < minLength) {
                    res = s.substring(left, right + 1);
                    minLength = right - left + 1;
                }
            }
//            if (right == s.length() - 1) break;
            flags2[s.charAt(left++)]--;
            while (left <= right && flags1[s.charAt(left)] == 0) {
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

}
