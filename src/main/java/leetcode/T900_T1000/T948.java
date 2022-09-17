package leetcode.T900_T1000;

import java.util.Arrays;

public class T948 {

    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, start = 0, end = tokens.length - 1;
        Arrays.sort(tokens);
        while (start <= end) {
            if (power >= tokens[start]) {
                ++score;
                power -= tokens[start++];
            } else if (start < end && score > 0) {
                --score;
                power += tokens[end--];
            } else {
                break;
            }
        }
        return score;
    }

}
