package leetcode.T400_T500;

public class T410 {

    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m > nums.length) return 0;
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        int left = max, right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, mid, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isValid(int[] nums, int target, int m) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                count++;
                sum = num;
                if (count > m) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        T410 solution = new T410();
        System.out.println(solution.splitArray(new int[]{7,2,5,10,8}, 2));
    }

}
