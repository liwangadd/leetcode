package leetcode.T900_T1000;

public class T926 {

    public int minFlipsMonoIncr(String s) {
        char[] sArr = s.toCharArray();
        int zeroCount = 0;
        for (char c : sArr) {
            if (c == '0') ++zeroCount;
        }
        int preZero = 0, preOne = 0, minFlip = Integer.MAX_VALUE;
        for (int i = 0; i < sArr.length; ++i) {
            minFlip = Math.min(minFlip, zeroCount - preZero + preOne);
            if (sArr[i] == '0') ++preZero;
            else ++preOne;
        }
        return Math.min(minFlip, zeroCount - preZero + preOne);
    }

    public static void main(String[] args) {
        new T926().minFlipsMonoIncr("00011000");
    }

}
