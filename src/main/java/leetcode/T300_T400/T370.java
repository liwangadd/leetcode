package leetcode.T300_T400;

public class T370 {

    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] res = new int[length];
        if (length <= 0) return res;
        for (int[] update : updates) {
            int startIndex = update[0] >= 0 ? update[0] : 0;
            int endIndex = update[1] < length ? update[1] : length - 1;
            int inc = update[2];
            for(int i=startIndex;i<=endIndex;++i){
                res[i]+=inc;
            }
        }
        return res;
    }

}
