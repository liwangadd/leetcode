import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.IntPredicate;

public class Main {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], building[2]});
            heights.add(new int[]{building[1], -building[2]});
        }
        heights.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                else return o2[1] - o1[1];
            }
        });
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int prev = 0, cur = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] height : heights) {
            if (height[1] > 0) {
                queue.add(height[1]);
                cur = queue.peek();
            } else if (height[1] < 0) {
                queue.remove(-height[1]);
                cur = queue.isEmpty() ? 0 : queue.peek();
            }
            if (cur != prev) {
                res.add(Arrays.asList(height[0], cur));
                prev = cur;
            }
        }
        return res;
    }

}

