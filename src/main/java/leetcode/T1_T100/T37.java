package leetcode.T1_T100;

public class T37 {

    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private boolean solve(char[][] board, int position) {
        if (position == 81) return true;
        int row = position / 9;
        int col = position % 9;
        if (board[row][col] == '.') {
            for (int i = 0; i < 9; ++i) {
                board[row][col] = (char) (i + '1');
                if (check(board, row, col)) {
                    if (solve(board, position + 1)) return true;
                }
                board[row][col] = '.';
            }
        } else {
            return solve(board, position + 1);
        }
        return false;
    }

    public boolean check(char[][] board, int row, int col) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == board[row][col] && i != row) {
                return false;
            }
            if (board[row][i] == board[row][col] && i != col) {
                return false;
            }
            int rowIndex = 3 * (row / 3) + i / 3;
            int colIndex = 3 * (row % 3) + i % 3;
            if (board[rowIndex][colIndex] == board[row][col] && (rowIndex != row || colIndex != col)) {
                return false;
            }
        }
        return true;
    }

}
