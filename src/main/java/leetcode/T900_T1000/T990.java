package leetcode.T900_T1000;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class T990 {

    public boolean equationsPossible(String[] equations) {
        Map<Character, Character> graph = new HashMap<>();
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                if (c1 == c2)
                    continue;
                Character p1 = c1, p2 = c2;
                while (graph.containsKey(p1))
                    p1 = graph.get(p1);
                while (graph.containsKey(p2))
                    p2 = graph.get(p2);
                if (!p2.equals(p1)) {
                    graph.put(p1, p2);
                }
                if (!p2.equals(c1))
                    graph.put(c1, p2);
                if (!p2.equals(c2))
                    graph.put(c2, p2);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                if (c1 == c2)
                    return false;
                Character p1 = c1, p2 = c2;
                while (graph.containsKey(p1))
                    p1 = graph.get(p1);
                while (graph.containsKey(p2))
                    p2 = graph.get(p2);
                if (p1.equals(p2))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        new T990().equationsPossible(new String[]{"a==b", "e==c", "b==c", "a!=e"});
        new T990().equationsPossible(new String[]{"a==b", "b==c", "a==c"});
    }

}
