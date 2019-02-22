package leetcode.T400_T500;

public class T493 {

    private int count = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        partSort(nums, 0, nums.length - 1);
        return count;
    }

    private int[] partSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[]{nums[start]};
        }
        if (start > end) {
            return new int[0];
        }
        int mid = start + (end - start) / 2;
        int[] res1 = partSort(nums, start, mid);
        int[] res2 = partSort(nums, mid + 1, end);
        return merge(res1, res2);
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0, index = 0;
        for (; index1 < nums1.length; ++index1) {
            for (index2 = 0; index2 < nums2.length; ++index2) {
                if (nums1[index1] <= nums2[index2] * 2) break;
            }
            count += index2;
        }
        index1 = 0;
        index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                res[index++] = nums1[index1++];
            } else {
                res[index++] = nums2[index2++];
            }
        }
        while (index1 < nums1.length) res[index++] = nums1[index1++];
        while (index2 < nums2.length) res[index++] = nums2[index2++];
        return res;
    }

    public static void main(String[] args) {
        T493 solution = new T493();
        System.out.println(solution.reversePairs(new int[]{2,4,3,5,1}));
    }

}
