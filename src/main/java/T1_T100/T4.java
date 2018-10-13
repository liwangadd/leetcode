package T1_T100;

public class T4 {

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        if (length1 < length2) return findMedianSortedArrays(nums2, nums1);
        int left = 0, right = length2 * 2;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = length1 + length2 - mid2;
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            int r1 = mid1 == length1 * 2 ? Integer.MAX_VALUE : nums1[mid1 / 2];
            int r2 = mid2 == length2 * 2 ? Integer.MAX_VALUE : nums2[mid2 / 2];
            if (l1 > r2) left = mid2 + 1;
            else if (l2 > r1) right = mid2 - 1;
            else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4, 5, 6, 7, 8}));
    }

}
