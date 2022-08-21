package leetcode.T800_T900;

import java.util.PriorityQueue;

public class T871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stops = 0;
        int reach = startFuel;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int i = 0;
        int n = stations.length;
        while (reach < target) {
            while (i < n && reach >= stations[i][0]) {
                pq.add(stations[i][1]);
                i++;
            }

            if (pq.isEmpty())
                return -1;

            reach += pq.poll();
            stops++;
        }

        return stops;
    }

}
