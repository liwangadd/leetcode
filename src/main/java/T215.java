import com.sun.deploy.panel.JHighDPITable;

public class T215 {

    public static int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int i = low + 1, j = high;
            int pivot = nums[low];
            while (i <= j) {
                while (i <= j && nums[i] <= pivot) {
                    i++;
                }
                while (i <= j && nums[j] >= pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(nums, i, j);
                }
            }
            swap(nums, low, j);
            if (j == nums.length - k) return nums[j];
            else if (j < nums.length - k) low = j + 1;
            else high = j - 1;
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
        int[] nums1 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums1, 4));
        int[] nums2 = new int[]{2, 1};
        System.out.println(findKthLargest(nums2, 2));
        int[] nums3 = new int[]{7, 6, 5, 4, 3, 2, 1};
        System.out.println(findKthLargest(nums3, 5));
    }

}
