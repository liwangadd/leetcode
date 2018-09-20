import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.Arrays;

public class T31 {

    public static void nextPermutation(int[] nums) {
        int keyIndex = nums.length - 1;
        while (keyIndex > 0 && nums[keyIndex - 1] >= nums[keyIndex]) {
            --keyIndex;
        }

        if (keyIndex == 0) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                swap(nums, left++, right--);
            }
        } else {
            for (int i = nums.length - 1; i >= keyIndex; --i) {
                if (nums[i] > nums[keyIndex - 1]) {
                    swap(nums, i, keyIndex - 1);
                    break;
                }
            }
            for (int i : nums) {
                System.out.print(i);
            }
            System.out.println();
            Arrays.sort(nums, keyIndex, nums.length);
            for (int i : nums) {
                System.out.print(i);
            }
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 0, 2, 3, 2, 0};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
