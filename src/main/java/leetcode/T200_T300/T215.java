package leetcode.T200_T300;

import java.util.PriorityQueue;

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

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHead = new PriorityQueue<>();
        for (int num : nums) {
            if (minHead.size() < k) minHead.add(num);
            else {
                if (minHead.peek() < num) {
                    minHead.poll();
                    minHead.add(num);
                }
            }
        }
        return minHead.peek();
    }

    public int findKthLargest3(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int i = low + 1, j = high;
            int pivot = nums[low];
            while (i <= j) {
                while (i <= j && nums[i] <= pivot) i++;
                while (i <= j && nums[j] >= pivot) j--;
                if (i < j) swap(nums, i, j);
            }
            swap(nums, low, j);
            if (j == nums.length - k) return nums[j];
            else if (j < nums.length - k) low = j + 1;
            else high = j - 1;
        }
        return nums[low];
    }

    public static void main(String[] args) {
        T215 solution = new T215();
        System.out.println(solution.findKthLargest3(new int[]{1,2,3,4,5,6,8,9,10,7}, 10));
//        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
//        System.out.println(findKthLargest(nums, 2));
//        int[] nums1 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
//        System.out.println(findKthLargest(nums1, 4));
//        int[] nums2 = new int[]{2, 1};
//        System.out.println(findKthLargest(nums2, 2));
//        int[] nums3 = new int[]{7, 6, 5, 4, 3, 2, 1};
//        System.out.println(findKthLargest(nums3, 5));
    }

}
