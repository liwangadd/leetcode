package leetcode.T800_T900;

import java.awt.geom.RectangularShape;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class T854 {

    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int distance = 0;
        queue.offer(s1);
        visited.add(s1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++distance;
            while (size-- > 0) {
                String pollStr = queue.poll();
                int index = 0;
                while (pollStr.charAt(index) == s2.charAt(index)) ++index;
                for (int i = index + 1; i < s1.length(); ++i) {
                    if (pollStr.charAt(i) != s2.charAt(i) && pollStr.charAt(index) == s2.charAt(i)) {
                        String str = swap(pollStr, index, i);
                        if (str.equals(s2)) return distance;
                        if (visited.add(str)) queue.offer(str);
                    }
                }
            }
        }
        return distance;
    }

    private String swap(String str, int i, int j) {
        char[] sArr = str.toCharArray();
        char hold = sArr[i];
        sArr[i] = sArr[j];
        sArr[j] = hold;
        return new String(sArr);
    }

    public static void main(String[] args) {
        new T854().kSimilarity("abac", "baca");
    }

}
