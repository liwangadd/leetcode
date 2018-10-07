import java.util.LinkedList;
import java.util.List;

public class T51 {

    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        if (n <= 0) return res;
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        solveOneRow(n, 0, new LinkedList<>());
        return res;
    }

    private void solveOneRow(int n, int index, List<Integer> resItem) {
        if (index == n) {
            List<String> solution = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    if (resItem.get(i) != j) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                solution.add(sb.toString());
            }
            res.add(solution);
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!col[i] && !dia1[index - i + n - 1] && !dia2[index + i]) {
                resItem.add(i);
                col[i] = true;
                dia1[index - i + n - 1] = true;
                dia2[index + i] = true;
                solveOneRow(n, index + 1, resItem);
                col[i] = false;
                dia1[index - i + n - 1] = false;
                dia2[index + i] = false;
                resItem.remove(resItem.size() - 1);
            }
        }
    }

}
