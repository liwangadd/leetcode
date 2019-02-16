package leetcode.T1_T100;

public class T69 {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                int plusOne = mid + 1;
                if (plusOne > x / plusOne) return mid;
                else left = mid + 1;
            }
        }
        return left;
    }

}
