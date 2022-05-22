package leetcode.T600_T700;

public class T639 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i <= s.length(); ++i) {
            char char1 = s.charAt(i - 2);
            char char2 = s.charAt(i - 1);
            if (char2 == '*') {
                dp[i] += 9 * dp[i - 1];
            } else if (char2 > '0') {
                dp[i] += dp[i - 1];
            }
            if (char1 == '*') {
                if (char2 == '*') {
                    dp[i] += 15 * dp[i - 2];
                } else if (char2 >= '0' && char2 <= '6') {
                    dp[i] += 2 * dp[i - 2];
                } else {
                    dp[i] += dp[i - 2];
                }
            } else if (char1 == '1' || char1 == '2') {
                if (char2 == '*') {
                    if (char1 == '1') {
                        dp[i] += 9 * dp[i - 2];
                    } else {
                        dp[i] += 6 * dp[i - 2];
                    }
                } else if (((char1 - '0') * 10 + (char2 - '0')) <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= 1000000007;
        }
        return (int) dp[s.length()];
    }

}
