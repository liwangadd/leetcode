package leetcode;

public class T1802 {

    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long leftSum = sum(index, mid);
            long rightSum = sum(n - index - 1, mid);
            if (leftSum + rightSum + mid <= maxSum) {
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private long sum(long count, long maxVal) {
        long zeroCount = Math.max(0, count - maxVal + 1);
        long nonZeroCount = count - zeroCount;
        return nonZeroCount * maxVal - (nonZeroCount + 1) * nonZeroCount / 2 + zeroCount;
    }
}
