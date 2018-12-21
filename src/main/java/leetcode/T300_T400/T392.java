package leetcode.T300_T400;

public class T392 {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length(); ++j) {
            if (s.charAt(i) == t.charAt(j)) ++i;
        }
        return i == s.length();
    }

}
