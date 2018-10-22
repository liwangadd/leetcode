package T200_T300;

public class T240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int top = 0, bottom = m;
        while (bottom >= 0 && matrix[bottom][0] > target) --bottom;
        while (top <= m && matrix[top][n] < target) ++top;
        for (int i = top; i <= bottom; ++i) {
            int left = 0, right = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] == target) return true;
                else if (matrix[i][mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T240 solution = new T240();
        System.out.println(solution.searchMatrix(new int[][]{{-5}}, -5));
    }

}
