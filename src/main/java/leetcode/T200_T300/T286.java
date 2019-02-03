package leetcode.T200_T300;

public class T286 {

    private int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        int rows = rooms.length, cols = rooms[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; ++j) {
                if (rooms[i][j] == 0) {
                    fillRooms(rooms, i, j, rooms[i][j]);
                }
            }
        }
    }

    private void fillRooms(int[][] rooms, int row, int col, int val) {
        rooms[row][col] = val++;
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (inArea(row, col, rooms) && rooms[newRow][newCol] != -1) {
                if (rooms[newRow][newCol] < val) {
                    fillRooms(rooms, newRow, newCol, val);
                }
            }
        }
    }

    private boolean inArea(int row, int col, int[][] rooms) {
        return row > -1 && row < rooms.length && col > -1 && col < rooms[0].length;
    }

}
