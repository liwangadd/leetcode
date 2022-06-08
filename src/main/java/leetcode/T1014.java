package leetcode;

public class T1014 {

    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0], res = 0;
        for (int i = 1; i < values.length; ++i) {
            res = Math.max(res, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return res;
    }

}
