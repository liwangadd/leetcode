public class T53 {

    private static int maxSubArray(int[] nums) {
        int right = 0;
        int sum = 0, maxSum = nums[0];
        while (right < nums.length) {
            sum += nums[right++];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, 1}));
        System.out.println(maxSubArray(new int[]{-2, -1}));
    }

}
