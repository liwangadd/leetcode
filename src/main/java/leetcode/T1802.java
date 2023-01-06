package leetcode;

public class T1802 {

    public int maxValue(int n, int index, int maxSum) {
        long start = 1, end = maxSum, res = 0;
        while (start <= end) {
            long mid = start + (end - start)/2;
            long leftSum = sum(Math.min(index, mid - 1), mid);
            long rightSum =  sum(Math.min(n - index - 1, mid - 1), mid);
            leftSum += Math.max(index - mid + 1, 0);
            rightSum += Math.max(n - index - 1 - mid + 1, 0);
            if (leftSum + rightSum + mid<= maxSum) {
                res = Math.max(res, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int)res;
    }

    private long sum(long i, long mid) {
        return mid * i - (i * (i + 1))/2;
    }

}
