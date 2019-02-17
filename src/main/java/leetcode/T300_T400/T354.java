package leetcode.T300_T400;

import java.util.Arrays;

public class T354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            else return o1[0] - o2[0];
        });
//        for (int[] envelope : envelopes) {
//            System.out.println(envelope[0] + "--" + envelope[1]);
//        }
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) index = -(index + 1);
            dp[index] = envelope[1];
            if (index == len) len++;
        }
        return len;
    }

}
