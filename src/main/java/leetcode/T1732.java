package leetcode;

public class T1732 {

    public int largestAltitude(int[] gain) {
        int maxHeight = 0, lastHeight = 0;
        for (int diff : gain) {
            lastHeight += diff;
            maxHeight = Math.max(maxHeight, lastHeight);
        }
        return maxHeight;
    }

}
