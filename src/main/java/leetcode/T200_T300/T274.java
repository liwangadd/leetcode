package leetcode.T200_T300;

import java.util.Arrays;

public class T274 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; ++i) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        T274 solution = new T274();
        System.out.println(solution.hIndex(new int[]{3, 0, 6, 1, 5}));
    }

}
