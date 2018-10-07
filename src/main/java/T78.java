import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());

        Arrays.sort(nums);
        generate(nums, 0, nums.length, res, new LinkedList<>());
        return res;
    }

    private void generate(int[] nums, int start, int end, List<List<Integer>> res, List<Integer> resItem) {
        for (int i = start; i < end; ++i) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            resItem.add(nums[i]);
            res.add(new ArrayList<>(resItem));
            generate(nums, i + 1, end, res, resItem);
            resItem.remove(resItem.size() - 1);
        }
    }

}
