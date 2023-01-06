package leetcode.T800_T900;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(rooms.get(0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer index = queue.poll();
                List<Integer> keys = rooms.get(index);
                visited[index] = true;
                for (Integer key : keys) {
                    if (!visited[key]) {
                        queue.add(key);
                    }
                }
            }
        }
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

}
