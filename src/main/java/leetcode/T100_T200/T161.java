package leetcode.T100_T200;

public class T161 {

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            return isOneEditDistance(t, s);
        }
        if (s.length() - t.length() > 1) return false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i + 1)) || s.substring(i + 1).equals(t.substring(i));
            }
        }
        return false;
    }

}
