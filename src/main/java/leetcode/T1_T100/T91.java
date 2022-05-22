package leetcode.T1_T100;

public class T91 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); ++i) {
            char char1 = s.charAt(i - 2);
            char char2 = s.charAt(i - 1);
            if (char2 > '0') dp[i] += dp[i - 1];
            if (char1 == '1' || char1 == '2' && char2 <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

}
