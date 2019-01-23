package leetcode.T400_T500;

public class T419 {

    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'X' && (j - 1 >= 0 && board[i][j - 1] == '.' || j == 0)
                        && (i - 1 >= 0 && board[i - 1][j] == '.' || i == 0))
                    ++count;
            }
        }
        return count;
    }

}
