package leetcode.T700_T800;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

public class T775 {

    public boolean isIdealPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 2) return true;
        int[] preMax = new int[len];
        preMax[0] = nums[0];
        preMax[1] = Math.max(preMax[0], nums[1]);
        for (int i = 2; i < len; ++i) {
            if(preMax[i-2]>nums[i])
                return false;
            preMax[i] = Math.max(preMax[i-1], nums[i]);
        }
        return true;
    }

}
