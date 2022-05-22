package leetcode.T500_T600;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T554 {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int edgeCount = 0;
        for (List<Integer> row : wall) {
            int cur = 0;
            for (int i = 0; i < row.size() - 1; ++i) {
                cur += row.get(i);
                map.compute(cur, (k, v) -> v == null ? 1 : v + 1);
                edgeCount = Math.max(map.get(cur), edgeCount);
            }
        }
        return wall.size() - edgeCount;
    }

    public static void main(String[] args) {
        int res = new T554().leastBricks(
                Lists.newArrayList(Lists.newArrayList(1, 2, 2, 1), Lists.newArrayList(3, 1, 2),
                        Lists.newArrayList(1, 3, 2), Lists.newArrayList(2, 4),
                        Lists.newArrayList(3, 1, 2), Lists.newArrayList(1, 3, 1, 1)));
        System.out.println(res);
    }
}
