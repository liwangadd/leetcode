package leetcode.T800_T900;

import java.util.Arrays;

public class T828 {

    public int uniqueLetterString(String s) {
        int[][] indexes = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(indexes[i], -1);
        }
        int res = 0, len = s.length();
        for (int i = 0; i < len; ++i) {
            int c = s.charAt(i) - 'A';
            res += (i - indexes[c][1]) * (indexes[c][1] - indexes[c][0]);
            indexes[c] = new int[]{indexes[c][1], i};
        }
        for (int i = 0; i < 26; i++) {
            res += (len - indexes[i][1]) * (indexes[i][1] - indexes[i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        new T828().uniqueLetterString("ABC");
    }

}
