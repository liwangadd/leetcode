package T200_T300;

import java.util.TreeSet;

public class T220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        T220 solution = new T220();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{-1, 2147483647}, 2, 3));
    }

}
