package leetcode;

import java.util.Arrays;

public class T2305 {

    private int res;

    public int distributeCookies(int[] cookies, int k) {
        this.res = Integer.MAX_VALUE;
        dfs(cookies, 0, new int[k]);
        return this.res;
    }

    private void dfs(int[] cookies, int pos, int[] sums) {
        if (pos == cookies.length) {
            int max = 0;
            for (int sum : sums) {
                max = Math.max(max, sum);
            }
            this.res = Math.min(res, max);
            return;
        }
        for (int i = 0; i < sums.length; i++) {
            sums[i] += cookies[pos];
            dfs(cookies, pos + 1, sums);
            sums[i] -= cookies[pos];
        }
    }

}
