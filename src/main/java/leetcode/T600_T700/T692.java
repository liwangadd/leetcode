package leetcode.T600_T700;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T692 {

    public static class Node implements Comparable<Node> {
        private String word;
        private int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count != o.count) {
                return o.count - this.count;
            }
            return word.compareTo(o.word);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.compute(word, (key, v) -> v == null ? 1 : v + 1);
        }
        return map.entrySet().stream()
                .map(entry -> new Node(entry.getKey(), entry.getValue()))
                .sorted()
                .limit(k)
                .map(n -> n.word)
                .collect(Collectors.toList());
    }

}
