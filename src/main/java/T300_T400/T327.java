package T300_T400;

public class T327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < nums.length; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = start + (end - start) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        long cache[] = new long[end - start];
        int t = mid, k = mid, l = mid;
        for (int i = start, r = 0; i < mid; ++r, ++i) {
            while (t < end && sums[t] - sums[i] < lower) ++t;
            while (k < end && sums[k] - sums[i] <= upper) ++k;
            count += k - t;
            while (l < end && sums[l] < sums[i]) cache[r++] = sums[l++];
            cache[r] = sums[i];
        }
        System.arraycopy(cache, 0, sums, start, l - start);
        return count;
    }

    public static void main(String[] args) {
        T327 solution = new T327();
        System.out.println(solution.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864));
    }

}
