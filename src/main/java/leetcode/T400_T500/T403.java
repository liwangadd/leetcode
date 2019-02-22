package leetcode.T400_T500;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class T403 {

    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(1);
        for (int i = 0; i < stones.length - 1; ++i) {
            for (Integer step : map.get(stones[i])) {
                int reach = step + stones[i];
                if (reach == stones[stones.length - 1]) return true;
                Set<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    set.add(step + 1);
                    if (step > 1) set.add(step - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T403 solution = new T403();
        System.out.println(solution.canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
