package leetcode.T800_T900;

import sun.awt.image.SurfaceManager;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class T857 {

    public double mincostToHireWorkers(int[] qualities, int[] wages, int k) {
        int len = qualities.length;
        Worker[] workers = new Worker[len];
        for (int i = 0; i < len; i++)
            workers[i] = new Worker(qualities[i], wages[i]);
        Arrays.sort(workers);
        Queue<Integer> queue = new PriorityQueue<>();
        int sumQuality = 0;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            sumQuality += workers[i].quality;
            queue.add(-workers[i].quality);
            if (queue.size() > k)
                sumQuality += queue.poll();
            if (queue.size() == k)
                res = Math.min(res, sumQuality * workers[i].ratio);
        }
        return res;
    }

    private static class Worker implements Comparable<Worker> {
        private final int quality;
        private final int wage;

        private final double ratio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = wage * 1.0 / quality;
        }

        public double getRatio() {
            return ratio;
        }


        @Override
        public int compareTo(Worker o) {
            return Double.compare(ratio, o.getRatio());
        }
    }

}
