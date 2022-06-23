package leetcode.T700_T800;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class T705 {

    private static final int BASE = 769;
    private LinkedList<Integer>[] data;

    public T705() {
        this.data = new LinkedList[BASE];
    }

    public void add(int key) {
        int index = key % BASE;
        if (data[index] == null) data[index] = new LinkedList<>();
        if(!contains(key)) data[index].add(key);
    }

    public void remove(int key) {
        int index = key % BASE;
        if (data[index] != null) {
            ListIterator<Integer> iter = data[index].listIterator();
            while (iter.hasNext()) {
                if (key == iter.next()) {
                    iter.remove();
                    break;
                }
            }
        }
    }

    public boolean contains(int key) {
        int index = key % BASE;
        if (data[index] != null) {
            for (Integer integer : data[index]) {
                if (key == integer) {
                    return true;
                }
            }
        }
        return false;
    }

}
