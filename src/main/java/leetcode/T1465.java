package leetcode;

import java.util.Arrays;

public class T1465 {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int count = candies[0] = 1;
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) candies[i] = ++count;
            else candies[i] = count = 1;
        }
        int sum = 0;
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            sum += candies[i];
        }
        return sum;
    }
}
