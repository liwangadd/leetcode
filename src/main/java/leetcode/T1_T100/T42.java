package leetcode.T1_T100;

public class T42 {

    public static int trap(int[] heights) {
        int res = 0;
        int maxHeight = 0, maxIndex = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxIndex = i;
            }
        }
        int prev = -1;
        for (int i = 0; i < maxIndex; i++) {
            if (heights[i] > prev) {
                prev = heights[i];
            }
            res += (prev - heights[i]);
        }

        int next = -1;
        for (int i = heights.length - 1; i > maxIndex; --i) {
            if (heights[i] > next) {
                next = heights[i];
            }
            res += (next - heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
