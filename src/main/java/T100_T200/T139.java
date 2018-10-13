package T100_T200;

import java.util.List;

public class T139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                String tmp = s.substring(j, i);
                dp[i] = dp[i] || (dp[j] && wordDict.contains(tmp));
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }

}
