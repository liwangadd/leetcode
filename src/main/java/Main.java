import com.sun.xml.internal.ws.api.pipe.SyncStartForAsyncFeature;

import java.awt.font.NumericShaper;

public class Main {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int start, int end, int k) {
        if (start > end) return -1;
        int partitionIndex = partition(nums, start, end);
        if (partitionIndex == nums.length - k) return nums[partitionIndex];
        else if (partitionIndex < nums.length - k) return findKthLargest(nums, partitionIndex + 1, end, k);
        else return findKthLargest(nums, start, partitionIndex - 1, k);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (nums[end] >= pivot && end > start) --end;
            nums[start] = nums[end];
            while (nums[start] <= pivot && start < end) ++start;
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int res = new Main().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(res);
    }
}
