package leetcode.T200_T300;

public class T260 {

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // 保留最低位的1
        diff &= -diff;
        int[] res = new int[2];
        for (int num : nums) {
            if ((diff & num) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }

}
