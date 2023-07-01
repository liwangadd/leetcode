package leetcode.T1200_T1300;

import java.util.Arrays;

public class T1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (c1, c2) -> c1[0] - c2[0]);
        int gcd = calcGcd(coordinates[1][0] - coordinates[0][0], coordinates[1][1] - coordinates[0][1]);
        int diffX = (coordinates[1][0] - coordinates[0][0]) / gcd;
        int diffY = (coordinates[1][1] - coordinates[0][1]) / gcd;
        for (int i = 2; i < coordinates.length; ++i) {
            int curGcd = calcGcd(coordinates[i][0] - coordinates[0][0], coordinates[i][1] - coordinates[0][1]);
            int curX = (coordinates[i][0] - coordinates[0][0]) / curGcd;
            int curY = (coordinates[i][1] - coordinates[0][1]) / curGcd;
            if (curX != diffX || curY != diffY) return false;
        }
        return true;
    }

    private int calcGcd(int a, int b) {
        if (b == 0) return a;
        return calcGcd(b, a % b);
    }

}
