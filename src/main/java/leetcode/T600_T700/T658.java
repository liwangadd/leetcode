package leetcode.T600_T700;

import java.util.LinkedList;
import java.util.List;

public class T658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        if (arr == null || arr.length == 0) return res;
        int left = 0, right = arr.length - 1, closestIndex = -1;
        while (left < right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = mid1 + 1;
            if (Math.abs(arr[mid1] - x) < Math.abs(arr[mid2] - x)) right = mid1;
            else if (Math.abs(arr[mid1] - x) > Math.abs(arr[mid2] - x)) left = mid2;
            else {
                if (arr[mid1] > x) right = mid1;
                else left = mid2;
            }
        }
        closestIndex = left;
        System.out.println(closestIndex);
        res.add(arr[closestIndex]);
        --k;
        int leftPos = closestIndex - 1, rightPos = closestIndex + 1;
        while (k-- != 0) {
            if (leftPos < 0 || rightPos < arr.length && Math.abs(arr[rightPos] - x) < Math.abs(arr[leftPos] - x)) {
                res.add(arr[rightPos++]);
            } else {
                res.addFirst(arr[leftPos--]);
            }
        }
        return res;
    }

}
