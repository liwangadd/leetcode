package leetcode.T600_T700;

public class T688 {

    private int[][] dir = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    private double[][][] cache;

    public double knightProbability(int n, int k, int row, int column) {
        cache = new double[n][n][k];
        return find(n, k, row, column);
    }

    private double find(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) return 1;
        if (k == 0) return 1;
        if (cache[row][column][k] != 0) return cache[row][column][k];
        double rate = 0;
        for (int[] direction : dir) {
            rate += 0.125 * find(n, k - 1, row + direction[0], column + direction[1]);
        }
        cache[row][column][k] = rate;
        return rate;
    }

}
