import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i, j, a, b, reserve;
        for (i = 0; i < nums.length - 3; i++) {
            for (j = i + 1; j < nums.length - 2; j++) {
                a = j + 1;
                b = nums.length - 1;
                reserve = target - nums[i] - nums[j];
                while (a < b) {
                    if (nums[a] + nums[b] > reserve) {
                        b--;
                        continue;
                    }
                    if (reserve == nums[a] + nums[b]) {
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[a]);
                        item.add(nums[b]);
                        result.add(item);

                    }
                    a++;
                    while (nums[a] == nums[a - 1] && a < b) {
                        a++;
                    }
                }
                while (nums[j] == nums[j + 1] && j < nums.length - 2) {
                    j++;
                }
            }
            while (nums[i] == nums[i + 1] && i < nums.length - 3) {
                i++;
            }
        }
        return result;
    }

}
