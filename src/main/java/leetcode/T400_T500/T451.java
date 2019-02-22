package leetcode.T400_T500;

import java.util.*;

public class T451 {

    class Node {
        int freq;
        char val;

        public Node(char val) {
            this.val = val;
            freq = 1;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Node> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).freq += 1;
            } else {
                Node node = new Node(c);
                map.put(c, node);
            }
        }
        List<Node> nodes = new ArrayList<>(map.values());
        nodes.sort((n1, n2) -> n2.freq - n1.freq);
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            while(node.freq--!=0){
                sb.append(node.val);
            }
        }
        return sb.toString();
    }

}
