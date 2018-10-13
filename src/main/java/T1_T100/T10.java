package T1_T100;

public class T10 {

    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        } else {
            int i = -1;
            while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                ++i;
            }
            return false;
        }
    }

    public boolean isMatchDp(String s, String p) {
        boolean[][] DP = new boolean[s.length() + 1][p.length() + 1];
        DP[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                DP[0][i] = DP[0][i - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    DP[i][j] = DP[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    DP[i][j] = DP[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        DP[i][j] = DP[i][j] || DP[i - 1][j];
                    }
                }
            }
        }
        return DP[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*ip*."));
    }

}
