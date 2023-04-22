package leetcode;

import javax.naming.spi.ResolveResult;
import java.util.Arrays;

public class T2405 {

    public int partitionString(String s) {
        boolean[] visited = new boolean[26];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (visited[c - 'a']) {
                ++res;
                Arrays.fill(visited, false);
            } else {
                visited[c - 'a'] = true;
            }
        }
        return res + 1;
    }

}
