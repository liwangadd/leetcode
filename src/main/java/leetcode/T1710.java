package leetcode;

import java.util.Arrays;

public class T1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);
        int sum = 0, res = 0;
        for (int[] boxType : boxTypes) {
            if (sum + boxType[0] <= truckSize) {
                res += boxType[0] * boxType[1];
                sum += boxType[0];
            } else {
                res += (truckSize - sum) * boxType[1];
                return res;
            }
        }
        return res;
    }

}
