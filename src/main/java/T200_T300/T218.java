package T200_T300;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class T218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new LinkedList<>();
        for (int[] building : buildings) {
            list.add(new int[]{building[0], building[2]});
            list.add(new int[]{building[1], -building[2]});
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        list.sort((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o2[1] - o1[1];
        });
        List<int[]> res = new LinkedList<>();
        int pre = 0, cur = 0;
        for (int[] height : list) {
            if (height[1] > 0) {
                maxHeap.add(height[1]);
                cur = maxHeap.peek();
            }
            if (height[1] < 0) {
                maxHeap.remove(-height[1]);
                cur = maxHeap.isEmpty() ? 0 : maxHeap.peek();
            }
            if (cur != pre) {
                res.add(new int[]{height[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}
