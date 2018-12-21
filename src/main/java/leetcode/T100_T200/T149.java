package leetcode.T100_T200;

import java.util.HashMap;
import java.util.Map;

public class T149 {

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

    public int maxPoints(Point[] points) {
        if (points.length < 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            int overlap = 0, max = 0;
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int j = i + 1; j < points.length; ++j) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    ++overlap;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max + overlap + 1);
        }
        return res;
    }

    private int generateGCD(int a, int b) {
        if (b == 0) return a;
        return generateGCD(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new T149().generateGCD(12, 18));
    }

}
