package leetcode;

public class T2441 {

    public int findMaxK(int[] nums) {
        boolean[] negHolder = new boolean[1001];
        boolean[] posHolders = new boolean[1001];
        int res = -1;
        for (int num : nums) {
            if (num < 0) {
                negHolder[-num] = true;
                if (posHolders[-num]) res = Math.max(res, -num);
            } else {
                posHolders[num] = true;
                if (negHolder[num]) res = Math.max(res, num);
            }
        }
        return res;
    }

}
