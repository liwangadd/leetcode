package leetcode.T1000_T1100;

import java.util.Arrays;
import java.util.Comparator;

public class T1024 {

    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, Comparator.comparingInt(a -> a[0]));
        int res = 0, reached = 0;
        for (int i = 0; i < clips.length && reached < time; ) {
            int maxReach = 0;
            for (; i < clips.length && clips[i][0] <= reached; ++i) {
                maxReach = Math.max(maxReach, clips[i][1]);
            }
            if (maxReach > reached) {
                reached = maxReach;
                ++res;
            } else {
                return -1;
            }
        }
        return reached >= time ? res : -1;
    }

    public static void main(String[] args) {
        int[][] clips = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        System.out.println(new T1024().videoStitching(clips, 9));
    }

}
