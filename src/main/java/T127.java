import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T127 {

    public static class Node {
        String str;
        int step;

        public Node(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size() + 1];
        queue.add(new Node(beginWord, 0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.str.equals(endWord)) return node.step + 1;
            for (int i = 0; i < wordList.size(); ++i) {
                if (!visited[i + 1] && isSimilar(node.str, wordList.get(i))) {
                    queue.add(new Node(wordList.get(i), node.step + 1));
                    visited[i + 1] = true;
                }
            }
        }
        return 0;
    }

    public static boolean isSimilar(String s1, String s2) {
        int len = s1.length();
        boolean similar = false;
        for (int i = 0; i < len; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (similar) return false;
                else similar = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
