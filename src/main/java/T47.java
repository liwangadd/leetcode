import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        permuteUnique(res, nums, 0);
        return res;
    }

    public void permuteUnique(List<List<Integer>> res, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> resItem = new ArrayList<>(nums.length);
            for (int num : nums) {
                resItem.add(num);
            }
            res.add(resItem);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = index; i < nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permuteUnique(res, nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    public void swap(int[] nums, int index, int i) {
        int tmp = nums[index];
        nums[index] = nums[i];
        nums[i] = tmp;
    }

}
