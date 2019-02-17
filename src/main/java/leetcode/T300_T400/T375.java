package leetcode.T300_T400;

public class T375 {

    public int getMoneyAmount(int n) {
        int[][] table = new int[n + 1][n + 1];
        for (int i = 2; i <= n; ++i) {
            for (int j = i - 1; j > 0; --j) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = j + 1; k < i; ++k) {
                    int localMax = k + Math.max(table[j][k - 1], table[k + 1][i]);
                    globalMin = Math.min(localMax, globalMin);
                }
                table[j][i] = j + 1 == i ? j : globalMin;
            }
        }
        return table[1][n];
    }

}
