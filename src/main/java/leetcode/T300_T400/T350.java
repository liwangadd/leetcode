package leetcode.T300_T400;

import java.util.Arrays;

public class T350 {

    private static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index1 = 0, index2 = 0, index3 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            while (index1 < nums1.length && nums1[index1] < nums2[index2]) {
                ++index1;
            }
            if (index1 == nums1.length) break;
            if (nums1[index1] == nums2[index2]) {
                result[index3++] = nums1[index1];
                ++index1;
                ++index2;
            } else {
                ++index2;
            }
        }
        int[] res = new int[index3];
        for (int i = 0; i < index3; ++i) {
            res[i] = result[i];
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : intersect(new int[]{4, 7, 9, 7, 6, 7}, new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : intersect(new int[]{0, 5, 8, 7, 2, 9, 7, 5}, new int[]{1, 4, 8, 9})) {
            System.out.print(i);
        }
    }

}
