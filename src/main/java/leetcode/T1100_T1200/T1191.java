package leetcode.T1100_T1200;

public class T1191 {

    int mod = (int) (Math.pow(10, 9) + 7);
    public int kConcatenationMaxSum(int[] arr, int k) {
        long singleMax = singleMax(arr);
        if (k == 1) return (int) singleMax;
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        long preMax = preMax(arr);
        long suffixMax = suffixMax(arr);
        if (sum > 0) {
            return (int) Math.max(singleMax % mod, ((sum * (k - 2)) % mod + preMax % mod + suffixMax % mod) % mod);
        } else {
            return (int) Math.max(singleMax % mod, (preMax % mod + suffixMax % mod) % mod);
        }
    }

    private long singleMax(int[] arr) {
        long currentSum = 0;
        long maxSum = Integer.MIN_VALUE;
        for (int num : arr) {
            currentSum = currentSum > 0 ? (currentSum + num) % mod : num;
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum < 0 ? 0 : maxSum % mod;
    }

    private long preMax(int[] arr) {
        long res = Integer.MIN_VALUE, sum = 0;
        for (int num : arr) {
            sum += num;
            res = Math.max(res, sum%=mod);
        }
        return res;
    }

    private long suffixMax(int[] arr) {
        long res = Integer.MIN_VALUE, sum = 0;
        for (int i = arr.length - 1; i >= 0; --i) {
            sum += arr[i];
            res = Math.max(res, sum%=mod);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }

}
