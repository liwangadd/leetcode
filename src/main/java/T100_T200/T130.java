package T100_T200;

public class T130 {

    private int xLimit, yLimit;
    private static int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        xLimit = board.length;
        yLimit = board[0].length;
        for (int i = 0; i < yLimit; i++) {
            if (board[0][i] == 'O') flip(board, 0, i, 'O', 'Z');
            if (board[xLimit - 1][i] == 'O') flip(board, xLimit - 1, i, 'O', 'Z');
        }
        for (int i = 0; i < xLimit; i++) {
            if (board[i][0] == 'O') flip(board, i, 0, 'O', 'Z');
            if (board[i][yLimit - 1] == 'O') flip(board, i, yLimit - 1, 'O', 'Z');
        }
        for (int i = 0; i < xLimit; i++) {
            for (int j = 0; j < yLimit; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void flip(char[][] board, int x, int y, char cur, char target) {
        board[x][y] = target;
        for (int i = 0; i < 4; ++i) {
            int newX = x + moves[i][0];
            int newY = y + moves[i][1];
            if (inArea(newX, newY) && board[newX][newY] == cur) {
                flip(board, newX, newY, cur, target);
            }
        }
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < xLimit && newY >= 0 && newY < yLimit;
    }


}
