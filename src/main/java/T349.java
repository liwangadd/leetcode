import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T349 {

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet2 = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            numSet2.add(num);
        }
        for (int num : nums1) {
            if (numSet2.contains(num)) {
                result.add(num);
                numSet2.remove(num);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : intersection(new int[]{4, 7, 9, 7, 6, 7}, new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4})) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : intersection(new int[]{0, 5, 8, 7, 2, 9, 7, 5}, new int[]{1, 4, 8, 9})) {
            System.out.print(i);
        }
    }

}
