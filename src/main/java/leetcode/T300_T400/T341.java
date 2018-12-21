package leetcode.T300_T400;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class T341 {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private List<NestedInteger> nestedList;
        private List<Integer> integerList;
        private Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            this.integerList = new LinkedList<>();
            for (NestedInteger nestedInteger : nestedList) {
                recursiveGetInteger(nestedInteger);
            }
            this.iterator = integerList.iterator();
        }

        private void recursiveGetInteger(NestedInteger nestedInteger) {
            if (nestedInteger.isInteger()) {
                integerList.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> itemList = nestedInteger.getList();
                for (NestedInteger nestedItem : itemList) {
                    recursiveGetInteger(nestedItem);
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

}
