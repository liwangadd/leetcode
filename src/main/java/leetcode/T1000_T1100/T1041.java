package leetcode.T1000_T1100;

public class T1041 {

    private static final int[][] MOVES = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean isRobotBounded(String instructions) {
        int direction = 0;
        int x = 0, y = 0;
        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'G') {
                    x += MOVES[direction][0];
                    y += MOVES[direction][1];
                } else if (c == 'R') {
                    direction = (direction + 1) % 4;
                } else {
                    direction = (direction + 3) % 4;
                }
            }
        }
        return x == 0 && y == 0;
    }

}
