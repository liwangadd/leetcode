package T1_T100;

public class T74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        if (matrix[0][0] > target) return false;
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] < target) top = mid + 1;
            else if (matrix[mid][0] > target) bottom = mid - 1;
            else return true;
        }
        int left = 0, right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[bottom][mid] < target) left = mid + 1;
            else if (matrix[bottom][mid] > target) right = mid - 1;
            else return true;
        }
        return false;
    }

}
