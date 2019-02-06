package leetcode.T300_T400;

import java.util.ArrayList;
import java.util.List;

public class T305 {

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    private int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) return res;
        boolean[][] visited = new boolean[n][m];
        int[] pars = new int[n * m];
        for (int i = 0; i < pars.length; ++i) pars[i] = i;
        int num = 0;
        for (Point operator : operators) {
            int x = operator.x, y = operator.y;
            int par1 = x * m + y;
            if(!visited[x][y]) {
                for (int[] move : moves) {
                    int nextX = x + move[0], nextY = y + move[1];
                    int par2 = nextX * m + nextY;
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY > m || !visited[nextX][nextY]) continue;
                    while (par1 != pars[par1]) {
                        pars[par1] = pars[pars[par1]];
                        par1 = pars[par1];
                    }
                    while (par2 != pars[par2]) {
                        pars[par2] = pars[pars[par2]];
                        par2 = pars[par2];
                    }
                    if (par1 != par2) {
                        pars[par1] = par2;
                        --num;
                    }
                }
                visited[x][y]=true;
                ++num;
            }
            res.add(num);
        }
        return res;
    }

}
