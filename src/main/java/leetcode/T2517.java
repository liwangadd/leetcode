package leetcode;

import java.util.Arrays;

public class T2517 {

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int lower = 0, upper = price[n - 1] - price[0];
        while (lower < upper) {
            int mid = (lower + upper + 1) / 2;
            if (check(price, mid, k)) lower = mid;
            else upper = mid - 1;
        }
        return lower;
    }

    private boolean check(int[] price, int step, int k) {
        int count = 1, lastPrice = price[0];
        for (int i = 1; i < price.length; ++i) {
            if (price[i] - lastPrice >= step) {
                lastPrice = price[i];
                if (++count >= k) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new T2517().maximumTastiness(
                new int[]{13, 5, 1, 8, 21, 2}, 3
        );
    }

}
