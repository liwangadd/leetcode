package leetcode.T600_T700;

public class T852 {

    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) return -1;
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = mid1 + 1;
            if (A[mid1] > A[mid2]) right = mid1;
            else left = mid2;
        }
        return left;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = mid1 + 1;
            if (A[mid1] > A[mid2]) right = mid1;
            else left = mid2;
        }
        return left;
    }

}
