package T1_T100;

public class T36 {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            int[] row = new int[9];
            int[] col = new int[9];
            int[] square = new int[9];
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1'] == 0) {
                        row[board[i][j] - '1'] = 1;
                    } else {
                        return false;
                    }
                }

                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1'] == 0) {
                        col[board[j][i] - '1'] = 1;
                    } else {
                        return false;
                    }
                }

                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.') {
                    if (square[board[rowIndex][colIndex] - '1'] == 0) {
                        square[board[rowIndex][colIndex] - '1'] = 1;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
