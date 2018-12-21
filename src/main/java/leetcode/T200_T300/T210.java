package leetcode.T200_T300;

import java.util.*;

public class T210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses == 0) return res;
        int index = 0;
        int[] indgree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (map.containsKey(prerequisite[0])) {
                map.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(prerequisite[1]);
                map.put(prerequisite[0], list);
            }
            indgree[prerequisite[1]]++;
        }

        for (int i = 0; i < numCourses; ++i) {
            int j = 0;
            for (; j < numCourses; ++j) {
                if (indgree[j] == 0) break;
            }
            if (j == numCourses) return new int[0];
            res[index++] = j;
            indgree[j]--;
            if (map.containsKey(j)) {
                List<Integer> neighbors = map.get(j);
                for (Integer neighbor : neighbors) {
                    indgree[neighbor]--;
                }
            }
        }
        for (int i = 0; i < numCourses / 2; ++i) {
            int tmp = res[i];
            res[i] = res[numCourses - i - 1];
            res[numCourses - i - 1] = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        T210 solution=new T210();
        for (int res : solution.findOrder(4, new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        })) {
            System.out.println(res);
        }
    }

}
