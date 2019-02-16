package leetcode.T200_T300;

import java.util.Iterator;
import java.util.List;

public class T251 {

    public class Vector2D implements Iterator<Integer> {

        private Iterator<List<Integer>> rowIterator;
        private Iterator<Integer> colIterator;

        public Vector2D(List<List<Integer>> vec2d) {
            // Initialize your data structure here
            rowIterator = vec2d.iterator();
        }

        @Override
        public Integer next() {
            // Write your code here
            return colIterator.next();
        }

        @Override
        public boolean hasNext() {
            // Write your code here
            while ((colIterator == null || !colIterator.hasNext()) && rowIterator.hasNext()) {
                colIterator = rowIterator.next().iterator();
            }
            return colIterator != null && colIterator.hasNext();
        }

        @Override
        public void remove() {
            colIterator.remove();
        }
    }


}
