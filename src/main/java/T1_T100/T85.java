package T1_T100;

import java.util.Arrays;

public class T85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] left = new int[n], right = new int[n];
        int[] height = new int[n];

        Arrays.fill(left, 0);
        Arrays.fill(right, n);
        Arrays.fill(height, 0);

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '0') {
                    left[j] = 0;
                    curLeft = j + 1;
                } else left[j] = Math.max(left[j], curLeft);
            }
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '0') {
                    right[j] = n;
                    curRight = j;
                } else right[j] = Math.min(right[j], curRight);
            }

            for (int j = 0; j < n; ++j) {
                ans = Math.max(ans, (right[j] - left[j]) * height[j]);
            }
        }
        return ans;
    }

}
