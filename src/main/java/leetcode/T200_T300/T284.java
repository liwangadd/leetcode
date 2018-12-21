package leetcode.T200_T300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class T284 implements Iterator<Integer> {

    private int current;
    private Iterator<Integer> iterator;
    private boolean valid;

    public T284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            current = iterator.next();
            valid = true;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return current;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int tmp = current;
        if (iterator.hasNext()) {
            current = iterator.next();
        } else {
            valid = false;
        }
        return tmp;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || valid;
    }

    public static void main(String[] args) {
        List<Integer> source = new LinkedList<>();
        source.add(1);
        source.add(2);
        source.add(3);
        T284 solution = new T284(source.iterator());
        System.out.println(solution.next());
        System.out.println(solution.peek());
        System.out.println(solution.next());
        System.out.println(solution.next());
        System.out.println(solution.hasNext());
    }
}
