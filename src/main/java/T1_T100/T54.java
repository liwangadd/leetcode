package T1_T100;

import java.util.LinkedList;
import java.util.List;

public class T54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) return res;

        int endRow = matrix.length - 1, startRow = 0;
        int endCol = matrix[0].length - 1, startCol = 0;
        while (endRow >= startRow && endCol >= startCol) {
            System.out.println(startRow + " " + endRow + " " + startCol + " " + endCol);
            for (int i = startCol; i <= endCol; ++i) res.add(matrix[startRow][i]);
            for (int i = startRow + 1; i < endRow; ++i) res.add(matrix[i][endCol]);
            if (startRow < endRow)
                for (int i = endCol; i >= startCol; --i) res.add(matrix[endRow][i]);
            if (startCol < endCol)
                for (int i = endRow - 1; i > startRow; --i) res.add(matrix[i][startCol]);
            ++startRow;
            --endRow;
            ++startCol;
            --endCol;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        List<Integer> res = spiralOrder(matrix);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }

}
