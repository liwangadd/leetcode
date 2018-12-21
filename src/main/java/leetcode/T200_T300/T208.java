package leetcode.T200_T300;

public class T208 {

    class Node {
        int val;
        Node[] children;
        boolean isWord;

        public Node(int val) {
            this.val = val;
            this.children = new Node[26];
            this.isWord = false;
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public T208() {
        root = new Node(-1);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (current.children[c] == null)
                current.children[c] = new Node(c);
            current = current.children[c];
        }
        current.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (current.children[c] == null) return false;
            current = current.children[c];
        }
        return current.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (current.children[c] == null) return false;
            current = current.children[c];
        }
        return true;
    }

}
