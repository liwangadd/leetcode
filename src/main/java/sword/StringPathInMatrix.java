package sword;

public class StringPathInMatrix {

    private final int[][] moves = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    private int rows, cols;

    public boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        rows = matrix.length;
        cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (backtracking(matrix, str, visited, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, String str, boolean[][] visited, int pathLen, int r, int c) {
        if (pathLen == str.length()) return true;
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || matrix[r][c] != str.charAt(pathLen))
            return false;
        visited[r][c] = true;
        boolean isSuccess = false;
        for (int[] move : moves) {
            if ((isSuccess = backtracking(matrix, str, visited, pathLen + 1, r + move[0], c + move[1])))
                break;
        }
        return isSuccess;
    }

}
