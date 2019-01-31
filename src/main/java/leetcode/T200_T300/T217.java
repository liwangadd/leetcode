package leetcode.T200_T300;

import java.util.HashSet;
import java.util.Set;

public class T217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> flags = new HashSet<>();
        for (int num : nums) {
            if(flags.contains(num)){
                return true;
            }else{
                flags.add(num);
            }
        }
        return false;
    }

}
