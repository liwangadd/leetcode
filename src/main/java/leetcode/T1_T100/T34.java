package leetcode.T1_T100;

public class T34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                res[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > -1; --i) {
            if (nums[i] == target) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    res[0] = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    res[1] = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        T34 solution = new T34();
        for (int pos : solution.searchRange2(new int[]{5, 7, 7, 8, 8, 10}, 6)) {
            System.out.println(pos);
        }
    }

}
