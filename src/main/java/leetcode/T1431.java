package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(extraCandies + candy >= max);
        }
        return res;
    }

}
