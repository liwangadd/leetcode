import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;

        List<Integer> numsList = new LinkedList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        permute(numsList, new LinkedList<>(), res);
        return res;
    }

    public void permute(List<Integer> nums, List<Integer> permu, List<List<Integer>> res) {
        if(nums.size()==0){
            List<Integer> itemList = new ArrayList<>(permu);
            res.add(itemList );
        }
        for (int i = 0; i < nums.size(); ++i) {
            Integer item = nums.get(i);
            permu.add(item);
            nums.remove(i);
            permute(nums, permu, res);
            nums.add(i, item);
            permu.remove(permu.size()-1);
        }
    }

}
