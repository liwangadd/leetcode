package leetcode;

public class T1680 {

    public int concatenatedBinary(int n) {
        long MOD = 1000_000_007;

        StringBuilder sb = new StringBuilder();
        int length = 0;
        long sum = 0;
        for (int i=1; i<=n; i++) {
            if ((i & i-1) == 0) {
                length++;
            }

            sum <<= length;
            sum += i;

            if (sum > MOD) {
                sum %= MOD;
            }
        }

        return (int)(sum % MOD);
    }

}
