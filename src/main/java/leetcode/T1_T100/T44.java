package leetcode.T1_T100;

public class T44 {

    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        int sLength = s.length(), pLength = p.length();
        boolean dp[][] = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pLength; ++i) {
            if (pArray[i - 1] == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int j = 1; j <= pLength; j++) {
            for (int i = 1; i <= sLength; i++) {
                if (pArray[j - 1] != '*') {
                    dp[i][j] = (sArray[i - 1] == pArray[j - 1] || pArray[j - 1] == '?') && dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[sLength][pLength];
    }
}
