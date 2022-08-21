package leetcode;

public class T1423 {

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] forwards = new int[k], backwards = new int[k];
        forwards[0] = cardPoints[0];
        backwards[0] = cardPoints[len - 1];
        for (int i = 1; i < k; ++i) {
            forwards[i] = cardPoints[i] + forwards[i - 1];
            backwards[i] = cardPoints[len - 1 - i] + backwards[i - 1];
        }
        int res = Math.max(forwards[k - 1], backwards[k - 1]);
        for (int i = 0; i < k - 1; ++i) {
            res = Math.max(forwards[i] + backwards[k - 2 - i], res);
        }
        return res;
    }

}
