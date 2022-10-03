package leetcode.T600_T700;

import java.util.LinkedList;
import java.util.List;

public class T658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = mid1 + 1;
            if (Math.abs(arr[mid1] - x) > Math.abs(arr[mid2] - x)) left = mid2;
            else if (Math.abs(arr[mid1] - x) < Math.abs(arr[mid2] - x)) right = mid1;
            else {
                if (arr[mid2] > x) right = mid1;
                else left = mid2;
            }
        }
        int closestIndex = left, leftPos = closestIndex - 1, rightPos = closestIndex + 1;
        LinkedList<Integer> res = new LinkedList<>();
        res.add(arr[closestIndex]);
        --k;
        while (k-- > 0) {
            if (rightPos >= arr.length || leftPos >= 0 && Math.abs(arr[leftPos] - x) <= Math.abs(arr[rightPos] - x))
                res.addFirst(arr[leftPos--]);
            else
                res.add(arr[rightPos++]);
        }
        return res;
    }

}
