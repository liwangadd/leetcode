package leetcode;

public class T2348 {

    public long zeroFilledSubarray(int[] nums) {
        long result =0, subarraysNum=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                result+=++subarraysNum;
            } else {
                subarraysNum=0;
            }
        }
        return result;
    }

}
