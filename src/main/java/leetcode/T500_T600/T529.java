package leetcode.T500_T600;

public class T529 {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (click[0] < 0 || click[0] >= board.length || click[1] < 0 || click[1] >= board[0].length)
            return board;
        int row = click[0], col = click[1];
        if (board[row][col] == 'X' || board[row][col] == 'B' || Character.isDigit(board[row][col]))
            return board;
        else if (board[row][col] == 'M')
            board[row][col] = 'X';
        else {
            int mineCount = 0;
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    int newRow = row + i, newCol = col + j;
                    if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                            && (board[newRow][newCol] == 'M' || board[newRow][newCol] == 'X')) {
                        ++mineCount;
                    }
                }
            }
            if (mineCount > 0) {
                board[row][col] = (char) (mineCount + '0');
            } else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; ++i) {
                    for (int j = -1; j < 2; ++j) {
                        int newRow = row + i, newCol = col + j;
                        updateBoard(board, new int[]{newRow, newCol});
                    }
                }
            }
        }
        return board;
    }

}
