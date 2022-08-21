package leetcode.T200_T300;

public class T240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) --col;
            else ++row;
        }
        return false;
    }

    public static void main(String[] args) {
        T240 solution = new T240();
        System.out.println(solution.searchMatrix(new int[][]{{-5}}, -5));
    }

}
