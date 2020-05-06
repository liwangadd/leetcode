package leetcode.T400_T500;

public class T498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length, column = matrix[0].length;
        int maxSum = row + column - 2;
        int[] result = new int[row * column];
        int index = 0;
        boolean reverse = false;
        for (int sum = 0; sum <= maxSum; ++sum) {
            if (reverse) {
                for (int i = 0; i <= sum; ++i) {
                    if (sum - i < column && i < row) {
                        result[index++] = matrix[i][sum - i];
                    }
                }
            } else {
                for (int i = sum; i >= 0; --i) {
                    if (sum - i < column && i < row) {
                        result[index++] = matrix[i][sum - i];
                    }
                }
            }
            reverse = !reverse;
        }
        return result;
    }

    public static void main(String[] args) {
        T498 test = new T498();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] res = test.findDiagonalOrder(matrix);
        for (int ele : res) {
            System.out.println(ele);
        }
    }
}
