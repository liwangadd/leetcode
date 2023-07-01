package leetcode;

import java.util.Arrays;

public class T1575 {

    private static final int MOD = (int) (1e9 + 7);

    private int[][] memo;

    private int n;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.n = locations.length;
        this.memo = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(locations, start, finish, fuel);
    }

    private int dfs(int[] locations, int curLoc, int targetLoc, int fuel) {
        if (fuel < 0) return 0;
        if (this.memo[curLoc][fuel] != -1) return this.memo[curLoc][fuel];
        int count = curLoc == targetLoc ? 1 : 0;
        for (int nextLoc = 0; nextLoc < this.n; ++nextLoc) {
            int cost = Math.abs(locations[nextLoc] - locations[curLoc]);
            if (nextLoc != curLoc && fuel >= cost) {
                count = (count + dfs(locations, nextLoc, targetLoc, fuel - cost)) % MOD;
            }
        }
        return this.memo[curLoc][fuel] = count;
    }

}
