package leetcode;

import java.util.Arrays;

public class T1641 {

    public int countVowelStrings(int n) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        int[][] dp = new int[n][26];
        for (char vowel : vowels) {
            dp[n - 1][vowel - 'a'] = 1;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (char vowel : vowels) {
                int sum = 0;
                for (char c : vowels) {
                    if (c <= vowel) {
                        sum += dp[n + 1][c];
                    }
                }
                dp[i][vowel] = sum;
            }
        }
        return Arrays.stream(dp[0]).sum();
    }

}
