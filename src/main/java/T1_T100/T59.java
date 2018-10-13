package T1_T100;

public class T59 {

    public static int[][] generateMatrix(int n) {
        int num = 1, end;
        int[][] res = new int[n][n];
        end = n / 2;
        for (int i = 0; i < end; ++i) {
            int row = i;
            int col = i;
            for (; col < n - i; ++col) {
                res[row][col] = num++;
            }
            for (--col, ++row; row < n - i - 1; ++row) {
                res[row][col] = num++;
            }
            for (; col >= i; --col) {
                res[row][col] = num++;
            }
            for (++col, --row; row > i; --row) {
                res[row][col] = num++;
            }
        }
        if (n % 2 == 1) res[end][end] = num;
        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(7);
        for (int[] row : res) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println("");
        }
    }

}
