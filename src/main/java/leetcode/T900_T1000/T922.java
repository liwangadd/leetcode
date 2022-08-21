package leetcode.T900_T1000;

public class T922 {

    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int oddIndex = 1, evenIndex = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                res[evenIndex] = num;
                evenIndex += 2;
            } else {
                res[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return res;
    }

}
