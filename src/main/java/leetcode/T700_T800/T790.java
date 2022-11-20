package leetcode.T700_T800;

public class T790 {

    private static final int MOD = (int) (1e9 + 7);

    public int numTilings(int n) {
        int[] twoLevel = new int[n + 3];
        int[] oneLevel = new int[n + 3];
        twoLevel[0] = twoLevel[1] = 1;
        for (int i = 2; i <= n; ++i) {
            twoLevel[i] = ((twoLevel[i - 1] + twoLevel[i - 2]) % MOD + oneLevel[i - 1]) % MOD;
            oneLevel[i] = ((twoLevel[i - 2] * 2) % MOD + oneLevel[i - 1]) % MOD;
        }
        return twoLevel[n];
    }

    public static void main(String[] args) {
        System.out.println(new T790().numTilings(29));
    }

}
