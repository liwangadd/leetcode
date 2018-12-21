package leetcode.T1_T100;

public class T79 {

    private int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int xLimit, yLimit;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        xLimit = board.length;
        yLimit = board[0].length;
        visited = new boolean[xLimit][yLimit];
        for (int i = 0; i < xLimit; ++i) {
            for (int j = 0; j < yLimit; ++j) {
                if (searchWord(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, int x, int y, String word, int index) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; ++i) {
                int newX = x + moves[i][0];
                int newY = y + moves[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && searchWord(board, newX, newY, word, index + 1)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < xLimit && newY >= 0 && newY < yLimit;
    }

}
