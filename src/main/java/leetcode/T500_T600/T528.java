package leetcode.T500_T600;

import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class T528 {

    private TreeMap<Integer, Integer> map;
    private Random random;
    private int length;

    public T528(int[] w) {
        random = new Random();
        map = new TreeMap<>();
        length = 0;
        for (int i = 0; i < w.length; i++) {
            map.put(length, i);
            length += w[i];
        }
    }

    public int pickIndex() {
        int pos = random.nextInt(length);
        return map.floorEntry(pos).getValue();
    }

}
