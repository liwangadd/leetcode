package leetcode.T500_T600;

import java.awt.geom.RectangularShape;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer[]> minCap = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));
        PriorityQueue<Integer[]> maxPro = new PriorityQueue<>((v1, v2) -> v2[1] - v1[1]);
        for (int i = 0; i < profits.length; i++) {
            minCap.add(new Integer[]{capital[i], profits[i]});
        }
        while (k-- > 0) {
            while (!minCap.isEmpty() && minCap.peek()[0] <= w) {
                maxPro.add(minCap.poll());
            }
            if (maxPro.isEmpty()) return w;
            w += maxPro.poll()[1];
        }
        return w;
    }

}
