import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int twoSum = 0 - nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] > twoSum) {
                    right--;
                } else if (nums[left] + nums[right] < twoSum) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < len && nums[left] == nums[left - 1])
                        left++;
                    right--;
                    while (right >= 0 && nums[right] == nums[right + 1])
                        right--;
                }
            }
            while (i < len - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        for (List<Integer> threeList : threeSum(new int[]{0, 0, 0, 0})) {
            for (Integer integer : threeList) {
                System.out.println(integer);
            }

        }
    }

}
