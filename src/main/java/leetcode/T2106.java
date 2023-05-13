package leetcode;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class T2106 {

    public int maxTotalFruits(int[][] fruits, int initPos, int k) {
        int len = fruits.length;
        int[] indices = new int[len], prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            indices[i] = fruits[i][0];
            prefixSum[i + 1] = prefixSum[i] + fruits[i][1];
        }
        int initIndex = Arrays.binarySearch(indices, initPos);
        initIndex = initIndex < 0 ? -initIndex - 1 : initIndex + 1;
        int start = Arrays.binarySearch(indices, initPos - k);
        start = start < 0 ? -start - 1 : start;
        int res = 0;
        for (int i = start; i <= Math.min(initIndex, len-1); ++i) {
            int doubleLen = Math.max(0, initPos - indices[i]) * 2;
            int end = initIndex;
            if (k - doubleLen > 0) {
                end = Arrays.binarySearch(indices, initPos + k - doubleLen);
                end = end < 0 ? -end - 1 : end + 1;
            }
            res = Math.max(res, prefixSum[end] - prefixSum[i]);
            int singleLen = initPos - indices[i];
            end = Arrays.binarySearch(indices, initPos + (k - singleLen) / 2);
            end = end < 0 ? -end - 1 : end + 1;
            res = Math.max(res, prefixSum[end] - prefixSum[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        new T2106().maxTotalFruits(
//                new int[][]{{0, 7}, {7, 4}, {9, 10}, {12, 6}, {14, 8}, {16, 5}, {17, 8}, {19, 4}, {20, 1}, {21, 3}, {24, 3}, {25, 3}, {26, 1}, {28, 10}, {30, 9}, {31, 6}, {32, 1}, {37, 5}, {40, 9}},
//                21,
//                30
//        );
        new T2106().maxTotalFruits(
                new int[][]{{2, 8}, {6, 3}, {8, 6}},
                5,
                4
        );
    }

}
