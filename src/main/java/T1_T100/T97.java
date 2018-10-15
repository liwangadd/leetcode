package T1_T100;

public class T97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        char[] s1Array = s1.toCharArray(), s2Array = s2.toCharArray(), s3Array = s3.toCharArray();

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); ++i) {
            dp[i][0] = dp[i-1][0] & s1Array[i - 1] == s3Array[i - 1];
        }
        for (int i = 1; i <= s2.length(); ++i) {
            dp[0][i] = dp[0][i - 1] & s2Array[i - 1] == s3Array[i - 1];
        }
        for (int i = 2; i <= s1.length(); ++i) {
            for (int j = 2; j <= s2.length(); ++j) {
                dp[i][j] = (dp[i - 1][j] & s1Array[i - 1] == s3Array[i + j - 1]) |
                        (dp[i][j - 1] & s2Array[j - 1] == s3Array[i + j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
