package leetcode.T900_T1000;

import java.util.Arrays;
import java.util.Comparator;

public class T977 {

    public int[] sortedSquares(int[] nums) {
        int[] res = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(Math::abs))
                .mapToInt(i -> i)
                .toArray();
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) Math.pow(res[i], 2);
        }
        return res;
    }

}
