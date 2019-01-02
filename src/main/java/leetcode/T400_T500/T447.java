package leetcode.T400_T500;

import java.util.HashMap;
import java.util.Map;

public class T447 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] point1 : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] point : points) {
                int dis = (point1[0] - point[0]) * (point1[0] - point[0]) + (point1[1] - point[1]) * (point1[1] - point[1]);
                if (!map.containsKey(dis)) {
                    map.put(dis, 1);
                } else {
                    map.put(dis, map.get(dis) + 1);
                }
            }
            for (Integer val : map.values()) {
                if (val > 1) {
                    res += factorial(val) / factorial(val - 2);
                }
            }
        }
        return res;
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; ++i) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        T447 solution=new T447();
        System.out.println(solution.numberOfBoomerangs(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}}));
    }

}
