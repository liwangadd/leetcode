package leetcode.T100_T200;

public class T154 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                --right;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        T154 solution=new T154();
        System.out.println(solution.findMin(new int[]{1}));
        System.out.println(solution.findMin(new int[]{2,2,2,0,1}));
    }

}
