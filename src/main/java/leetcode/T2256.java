package leetcode;

public class T2256 {

    public int minimumAverageDifference(int[] nums) {
        int len = nums.length;
        long preSum = 0, postSum = 0;
        for (int num : nums) postSum += num;
        int minIndex = len - 1, minDis = (int) (postSum / len);
        for (int i = 0; i < len - 1; ++i) {
            preSum += nums[i];
            postSum -= nums[i];
            int dis = Math.abs((int) (preSum / (i + 1)) - (int) (postSum / (len - i - 1)));
            if (dis < minDis || (dis == minDis && minIndex > i)) {
                minDis = dis;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
    }

}
