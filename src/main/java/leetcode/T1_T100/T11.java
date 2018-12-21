package leetcode.T1_T100;

public class T11 {

    private static int maxArea(int[] height) {
        int low = 0, high = height.length - 1;
        int width = high - low;
        int squre = Math.min(height[low], height[high]) * width;
        while (low < high) {
            if (height[low] < height[high]) {
                ++low;
            } else {
                --high;
            }
            if (Math.min(height[low], height[high]) * (--width) > squre) {
                squre = Math.min(height[low], height[high]) * width;
            }
        }
        return squre;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

}
