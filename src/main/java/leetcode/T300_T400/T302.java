package leetcode.T300_T400;

public class T302 {

    private int left, right, top, bottom;
    private int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        left = image[0].length;
        top = image.length;
        helper(image, x, y);
        return (right - left + 1) * (bottom - top + 1);
    }

    private void helper(char[][] image, int x, int y) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] == '0') return;
        left = Math.min(left, y);
        right = Math.max(right, y);
        top = Math.min(top, x);
        bottom = Math.max(bottom, x);
        image[x][y] = '0';
        for (int[] move : moves) {
            helper(image, x + move[0], y + move[1]);
        }
    }

}
