package leetcode.T500_T600;

import java.util.HashSet;
import java.util.Set;

public class T575 {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int type : candyType) {
            set.add(type);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

}
