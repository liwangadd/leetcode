package leetcode.T200_T300;

import java.util.List;

public class T281 {

    public class ZigzagIterator {

        private List<Integer> v1;
        private List<Integer> v2;
        private int index1;
        private int index2;
        private boolean turn;

        /*
         * @param v1: A 1d vector
         * @param v2: A 1d vector
         */
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            // do intialization if necessary
            this.v1 = v1;
            this.v2 = v2;
            this.index1 = 0;
            this.index2 = 0;
            this.turn = false;
        }

        /*
         * @return: An integer
         */
        public int next() {
            // write your code here
            this.turn = !this.turn;
            if (this.turn) {
                if (this.index1 < this.v1.size()) {
                    return this.v1.get(this.index1++);
                } else {
                    return this.v2.get(this.index2++);
                }
            } else {
                if (this.index2 < this.v2.size()) {
                    return this.v2.get(this.index2++);
                } else {
                    return this.v1.get(this.index1++);
                }
            }
        }

        /*
         * @return: True if has next
         */
        public boolean hasNext() {
            // write your code here
            return index1 < v1.size() || index2 < v2.size();
        }
    }

}
