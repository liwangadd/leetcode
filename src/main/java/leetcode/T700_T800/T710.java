package leetcode.T700_T800;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class T710 {

    private int M;
    private Random r;
    private Map<Integer, Integer> map;

    public T710(int N, int[] blacklist) {
        map = new HashMap<>();
        for (int b : blacklist)
            map.put(b, -1);
        M = N - map.size();

        for (int b : blacklist) {
            if (b < M) {
                while (map.containsKey(N - 1))
                    N--;
                map.put(b, N - 1);
                N--;
            }
        }

        r = new Random();
    }

    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }

}
