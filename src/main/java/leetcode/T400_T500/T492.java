package leetcode.T400_T500;

public class T492 {

    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area), l;
        while (area % w != 0) {
            w -= 1;
        }
        l = area / w;
        return new int[]{l, w};
    }

}
