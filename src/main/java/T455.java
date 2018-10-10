import java.util.Arrays;

public class T455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        for (int i = 0, j = 0; j < s.length && i < g.length; ++j) {
            if (g[i] <= s[j]) {
                ++i;
                ++count;
            }
        }
        return count;
    }

}
