package leetcode.T800_T900;

public class T801 {

    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] swap = new int[len], unSwap = new int[len];
        swap[0] = 1;
        for (int i = 1; i < len; ++i) {
            swap[i] = unSwap[i] = len;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                swap[i] = swap[i - 1] + 1;
                unSwap[i] = unSwap[i - 1];
            }
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                swap[i] = Math.min(swap[i - 1], unSwap[i - 1] + 1);
                unSwap[i] = Math.min(unSwap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[len - 1], unSwap[len - 1]);
    }

}
