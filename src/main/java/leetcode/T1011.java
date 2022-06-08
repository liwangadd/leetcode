package leetcode;

import java.lang.reflect.WildcardType;
import java.util.Arrays;

public class T1011 {

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(weights, mid, days)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean isValid(int[] weights, int target, int count) {
        int res = 1, cur = 0;
        for (int weight : weights) {
            if (cur + weight > target) {
                ++res;
                cur = weight;
            } else {
                cur += weight;
            }
        }
        return res <= count;
    }
}
