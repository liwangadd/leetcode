
public class T76 {

    private static String minWindow(String s, String t) {
        int minLength = s.length() + 1;
        String res = "";
        int left = 0, count = 0;
        int[] flags1 = new int[256], flags2 = new int[256];

        for (int i = 0; i < t.length(); ++i) {
            flags1[t.charAt(i)]++;
        }

        for (int right = 0; right < s.length(); ++right) {
            if (flags1[s.charAt(right)] != 0) {
                flags2[s.charAt(right)]++;
                if (flags1[s.charAt(right)] >= flags2[s.charAt(right)]) ++count;
                while (count == t.length()) {
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                    if (flags1[s.charAt(left)] != 0) {
                        flags2[s.charAt(left)]--;
                        if (flags1[s.charAt(left)] > flags2[s.charAt(left)]) --count;
                    }
                    ++left;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("ab", "b"));
        System.out.println(minWindow("a", "b"));
        System.out.println(minWindow("ewcwaefgc", "cae"));
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }

}
