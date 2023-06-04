package leetcode;

public class T1130 {

    private int[][][] cache;

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        this.cache = new int[n + 1][n + 1][2];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            int[] leftRes = dfs(arr, 0, i), rightRes = dfs(arr, i, n);
            res = Math.min(res, leftRes[1] + rightRes[1] + leftRes[0] * rightRes[0]);
        }
        return res;
    }

    private int[] dfs(int[] arr, int left, int right) {
        if (left + 1 == right) return new int[]{arr[left], 0};
        if (cache[left][right][0] > 0) return cache[left][right];
        int[] res = cache[left][right];
        res[0] = arr[left];
        res[1] = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; ++i) {
            int[] leftRes = dfs(arr, left, i), rightRes = dfs(arr, i, right);
            res[0] = Math.max(res[0], arr[i]);
            res[1] = Math.min(res[1], leftRes[1] + rightRes[1] + leftRes[0] * rightRes[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        new T1130().mctFromLeafValues(new int[]{4, 11});
    }

}
