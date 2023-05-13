package leetcode.T800_T900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class T839 {

    public int numSimilarGroups(String[] strs) {
        Map<String, String> parents = new HashMap<>();
        Set<String> visited = new HashSet<>(), unvisited = new HashSet<>();
        for (String str : strs) {
            parents.put(str, str);
            unvisited.add(str);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(strs[0]);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            unvisited.remove(str);
            for (String next : unvisited) {
                if (isSimilar(str, next)) {
                    parents.put(next, str);
                    queue.add(next);
                }
            }
            if (queue.isEmpty() && !unvisited.isEmpty()) {
                String next = unvisited.iterator().next();
                queue.add(next);
                visited.add(next);
            }
        }
        int res = 0;
        for (Map.Entry<String, String> entry : parents.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) ++res;
        }
        return res;
    }

    private boolean isSimilar(String str1, String str2) {
        int pos1 = -1, pos2 = -1, len = str1.length();
        for (int i = 0; i < len; ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (pos1 == -1) pos1 = i;
                else if (pos2 == -1) pos2 = i;
                else return false;
            }
        }
        return str1.charAt(pos1) == str2.charAt(pos2) && str1.charAt(pos2) == str2.charAt(pos1);
    }

    public static void main(String[] args) {
        new T839().numSimilarGroups(
                new String[]{"jvhpg", "jhvpg", "hpvgj", "hvpgj", "vhgjp"}
        );
    }

}
