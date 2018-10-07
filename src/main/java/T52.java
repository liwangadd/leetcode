public class T52 {

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        solveOneRow(n, 0);
        return count;
    }

    private void solveOneRow(int n, int index) {
        if (index == n) {
            ++count;
        }
        for (int i = 0; i < n; ++i) {
            if (!col[i] && !dia1[index - i + n - 1] && !dia2[index + i]) {
                col[i] = true;
                dia1[index - i + n - 1] = true;
                dia2[index + i] = true;
                solveOneRow(n, index + 1);
                col[i] = false;
                dia1[index - i + n - 1] = false;
                dia2[index + i] = false;
            }
        }
    }

}
