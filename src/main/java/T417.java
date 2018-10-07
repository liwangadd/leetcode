import java.util.LinkedList;
import java.util.List;

public class T417 {

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return res;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean PV[][] = new boolean[n][m];
        boolean AV[][] = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            flow(PV, matrix, i, 0, n, m);
            flow(AV, matrix, i, m - 1, n, m);
        }

        for (int i = 0; i < m; ++i) {
            flow(PV, matrix, 0, i, n, m);
            flow(AV, matrix, n - 1, i, n, m);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (PV[i][j] && AV[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void flow(boolean[][] visited, int[][] matrix, int x, int y, int n, int m) {
        visited[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (inArea(newX, newY, n, m) && !visited[newX][newY] && matrix[newX][newY] >= matrix[x][y]) {
                flow(visited, matrix, newX, newY, n, m);
            }
        }
    }

    private boolean inArea(int newX, int newY, int n, int m) {
        return newX >= 0 && newX < n && newY >= 0 && newY < m;
    }

}
