package leetcode.T300_T400;

public class T351 {

    private int[][] hash;
    private boolean[] visited;

    public int numberOfPatterns(int m, int n) {
        // Write your code here
        hash = new int[10][10];
        hash[1][9] = hash[9][1] = hash[3][7] = hash[7][3] = 5;
        hash[2][8] = hash[8][2] = hash[4][6] = hash[6][4] = 5;
        hash[1][3] = hash[3][1] = 2;
        hash[1][7] = hash[7][1] = 4;
        hash[7][9] = hash[9][7] = 8;
        hash[3][9] = hash[9][3] = 6;
        visited = new boolean[10];
        visited[0]=true;
        return helper(m, n, 1, 1) * 4 + helper(m, n, 1, 2) * 4 + helper(m, n, 1, 5);
    }

    private int helper(int m, int n, int len, int num) {
        int cnt = 0;
        if (len >= m) ++cnt;
        if (++len > n) return cnt;
        visited[num] = true;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && visited[hash[num][i]]) {
                cnt += helper(m, n, len + 1, i);
            }
        }
        visited[num] = false;
        return cnt;
    }

}
