package leetcode.T700_T800;

public class T707 {

    private static class Node {
        private int val;
        private Node prev;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;

    public T707() {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int index) {
        Node node = this.head;
        for (int i = -1; i < index && node != this.tail; ++i) {
            node = node.next;
        }
        return node == this.tail ? -1 : node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        this.head.next.prev = node;
        node.next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        this.tail.prev.next = node;
        node.prev = this.tail.prev;
        this.tail.prev = node;
        node.next = this.tail;
    }

    public void addAtIndex(int index, int val) {
        Node node = this.head;
        int i = -1;
        for (i = -1; i < index && node != tail; ++i) {
            node = node.next;
        }
        if (node == tail && i == index) addAtTail(val);
        else if (node != tail) {
            Node added = new Node(val);
            node.prev.next = added;
            added.prev = node.prev;
            added.next = node;
            node.prev = added;
        }
    }

    public void deleteAtIndex(int index) {
        Node node = this.head;
        for (int i = -1; i < index && node != tail; ++i) {
            node = node.next;
        }
        if (node != tail) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

}
