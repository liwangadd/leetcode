package leetcode.T300_T400;

import java.util.List;

public class T346 {

    public class MovingAverage {

        private int size;
        private int[] arr;
        private int pos;
        private double sum;
        private int count;

        /*
         * @param size: An integer
         */
        public MovingAverage(int size) {
            // do intialization if necessary
            this.size = size;
            this.arr = new int[size];
            this.pos = 0;
            this.sum = 0;
        }

        /*
         * @param val: An integer
         * @return:
         */
        public double next(int val) {
            // write your code here
            if (count < size) ++count;
            sum -= arr[pos];
            sum += val;
            arr[pos] = val;
            pos = (++pos) % size;
            return sum / count;
        }
    }

}
