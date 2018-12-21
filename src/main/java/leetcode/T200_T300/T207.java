package leetcode.T200_T300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class T207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return false;
        int[] indgree = new int[numCourses];
        Map<Integer, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < prerequisites.length; ++i) {
            if (hash.containsKey(prerequisites[i][1])) {
                hash.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(prerequisites[i][0]);
                hash.put(prerequisites[i][1], list);
            }
            indgree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; ++i) {
            int j = 0;
            for (; j < numCourses; ++j) {
                if (indgree[j] == 0) break;
            }
            if (j == numCourses) return false;
            indgree[j]--;
            if (hash.containsKey(j))
                for (Integer m : hash.get(j)) indgree[m]--;
        }
        return true;
    }

    public static void main(String[] args) {
        T207 solution = new T207();
        System.out.println(solution.canFinish(2, new int[][]{
                {1, 0}, {0, 1}
        }));
    }

}
