package leetcode.T200_T300;

public class T276 {

    public int numWays(int n, int k) {
        // write your code here
        if (n == 0 || k == 0) return 0;
        int diff = k, same = 0;
        for (int i = 1; i < n; ++i) {
            int diff2 = diff * (k - 1) + same * (k - 1);
            int same2 = diff;
            diff = diff2;
            same = same2;
        }
        return diff + same;
    }

    public static void main(String[] args) {
        T276 solution = new T276();
        System.out.println(solution.numWays(3, 1));
    }

}
