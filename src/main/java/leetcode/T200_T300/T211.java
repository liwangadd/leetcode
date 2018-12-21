package leetcode.T200_T300;

public class T211 {

    class Node {
        int val;
        boolean isWord;
        Node[] children;

        public Node(int val) {
            this.val = val;
            isWord = false;
            children = new Node[26];
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public T211() {
        root = new Node(-1);
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Node(c);
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        Node current = root;
        return search(current, word);
    }

    public boolean search(Node current, String subWord) {
        for (int i = 0; i < subWord.length(); ++i) {
            if (subWord.charAt(i) == '.') {
                for (Node child : current.children) {
                    if (child != null && search(child, subWord.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (current.children[subWord.charAt(i) - 'a'] == null) return false;
            }
            current = current.children[subWord.charAt(i) - 'a'];
        }
        return current.isWord;
    }

    public static void main(String[] args) {
        T211 solution = new T211();
        solution.addWord("bad");
        solution.addWord("dad");
        solution.addWord("mad");

        System.out.println(solution.search("pad"));
        System.out.println(solution.search("bad"));
        System.out.println(solution.search(".ad"));
        System.out.println(solution.search("b.."));
    }

}
