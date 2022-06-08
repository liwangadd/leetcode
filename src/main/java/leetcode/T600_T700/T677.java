package leetcode.T600_T700;

public class T677 {

    private static class Node {
        private int val;

        private int sum;
        private Node[] children;

        public Node() {
            this.val = 0;
            this.sum = 0;
            this.children = new Node[26];
        }
    }

    private Node root;

    public T677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node node = root;
        for (int i = 0; i < key.length(); i++) {
            int id = key.charAt(i) - 'a';
            if (node.children[id] == null) {
                node.children[id] = new Node();
                node.children[id].sum = val;
            } else {
                node.children[id].sum += val;
            }
            node = node.children[id];
        }
        if (node.val != 0 && node.val != val) {
            int originVal = node.val;
            node = root;
            for (int i = 0; i < key.length(); i++) {
                int id = key.charAt(i) - 'a';
                node.children[id].sum -= originVal;
                node = node.children[id];
            }
        }
        node.val = val;
    }

    public int sum(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int id = prefix.charAt(i) - 'a';
            if (node.children[id] == null) return 0;
            else node = node.children[id];
        }
        return node.sum;
    }

}
