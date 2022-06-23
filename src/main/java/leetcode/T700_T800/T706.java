package leetcode.T700_T800;

import java.util.LinkedList;
import java.util.ListIterator;

public class T706 {

    private static class Node {
        private int key;
        private int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static final int BASE = 769;
    private LinkedList<Node>[] data;

    public T706() {
        this.data = new LinkedList[BASE];
    }

    public void put(int key, int value) {
        int index = key % BASE;
        if (data[index] == null) data[index] = new LinkedList<>();
        for (Node node : data[index]) {
            if (node.key == key) {
                node.val = value;
                return;
            }
        }
        data[index].add(new Node(key, value));
    }

    public int get(int key) {
        int index = key % BASE;
        if (data[index] != null) {
            for (Node node : data[index]) {
                if (node.key == key) {
                    return node.val;
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % BASE;
        if (data[index] != null) {
            ListIterator<Node> iter = data[index].listIterator();
            while (iter.hasNext()) {
                if (key == iter.next().key) {
                    iter.remove();
                    return;
                }
            }
        }
    }

}
