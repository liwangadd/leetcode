package T100_T200;

public class T200 {

    private static int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int xLimit, yLimit;
    private static boolean[][] visited;
    private static int landCount = 0;

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        xLimit = grid.length;
        yLimit = grid[0].length;
        visited = new boolean[xLimit][yLimit];
        for (int i = 0; i < xLimit; ++i) {
            for (int j = 0; j < yLimit; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    searchIslands(grid, i, j);
                    ++landCount;
                }
            }
        }
        return landCount;
    }

    private static void searchIslands(char[][] grid, int x, int y) {
        if (visited[x][y]) return;
        if (grid[x][y] == '0') return;
        visited[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            int newX = x + moves[i][0];
            int newY = y + moves[i][1];
            if (inArea(newX, newY))
                searchIslands(grid, newX, newY);
        }
    }

    private static boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < xLimit && newY >= 0 && newY < yLimit;
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

}
