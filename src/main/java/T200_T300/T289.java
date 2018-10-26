package T200_T300;

public class T289 {

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int[] preRow = new int[board[0].length];
        int pre = 0;
        for (int i = 0, len = board.length; i < len; ++i) {
            int[] curRow = new int[board[0].length];
            for (int j = 0, len1 = board[0].length; j < len1; ++j) {
                int count = countLives(board, preRow, pre, i, j);
                curRow[j] = board[i][j];
                pre = curRow[j];
                if (count < 2) board[i][j] = 0;
                else if (count > 3) board[i][j] = 0;
                else if (count == 3) board[i][j] = 1;
            }
            pre = 0;
            preRow = curRow;
        }
    }

    private int countLives(int[][] board, int[] preRow, int pre, int i, int j) {
        int count = pre;
        if (j > 0 && preRow[j - 1] == 1) ++count;
        if (preRow[j] == 1) ++count;
        if (j < board[0].length - 1) {
            if (board[i][j + 1] == 1) ++count;
            if (preRow[j + 1] == 1) ++count;
        }
        if (i < board.length - 1) {
            if (j < board[0].length - 1 && board[i + 1][j + 1] == 1) ++count;
            if (board[i + 1][j] == 1) ++count;
            if (j > 0 && board[i + 1][j - 1] == 1) ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        T289 solution = new T289();
        int[][] board = new int[][]{
                {0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}
        };
        solution.gameOfLife(board);
        for (int[] row : board) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

}
