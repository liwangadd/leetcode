package leetcode;

public class T1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preXor = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; ++i) {
            preXor[i] = preXor[i - 1] ^ arr[i - 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = preXor[queries[i][0]] ^ preXor[queries[i][1] + 1];
        }
        return res;
    }

}
