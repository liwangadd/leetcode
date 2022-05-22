package leetcode.T500_T600;

public class T553 {

    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        if (nums.length == 1) return String.valueOf(nums[0]);
        StringBuilder sb = new StringBuilder();
        if (nums.length == 2) return sb.append(nums[0]).append("/").append(nums[2]).toString();
        sb.append(nums[0]).append("/(");
        for (int i = 1; i < nums.length; ++i) {
            sb.append(nums[i]).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

}
