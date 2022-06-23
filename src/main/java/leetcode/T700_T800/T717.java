package leetcode.T700_T800;

public class T717 {

    public boolean isOneBitCharacter(int[] bits) {
        if (bits[bits.length - 1] != 0) return false;
        boolean[] dp = new boolean[bits.length];
        dp[0] = true;
        for (int i = 1; i < bits.length; ++i) {
            if (bits[i - 1] == 0) dp[i] |= dp[i - 1];
            if (i >= 2 && bits[i - 2] == 1) dp[i] |= dp[i - 2];
        }
        return dp[bits.length - 1];
    }

}
