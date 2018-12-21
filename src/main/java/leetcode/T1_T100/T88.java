package leetcode.T1_T100;

public class T88 {

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i > -1 || j > -1) {
            if (j < 0) break;
            else if (i > -1 && nums1[i] >= nums2[j]) {
                nums1[lastIndex--] = nums1[i--];
            } else {
                nums1[lastIndex--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        for (int num : nums1) {
            System.out.println(num);

        }
    }

}
