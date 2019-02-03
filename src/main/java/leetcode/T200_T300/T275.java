package leetcode.T200_T300;

import java.util.Arrays;

public class T275 {

    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2, cnt = right - mid;
            if (citations[mid] < cnt) left = mid + 1;
            else right = mid - 1;
        }
        return citations.length - left;
    }

}
