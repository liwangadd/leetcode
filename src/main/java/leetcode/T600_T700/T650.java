package leetcode.T600_T700;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T650 {

    public int minSteps(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        res[1] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; i + i * j <= n; ++j) {
                res[i + i * j] = Math.min(res[i + i * j], res[i] + j + 1);
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        int res = new T650().minSteps(77);
        System.out.println(res);
    }

}
