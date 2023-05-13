package leetcode;

public class T1964 {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length, monoLen = 0;
        int[] mono = new int[len], res = new int[len];
        for (int i = 0; i < len; ++i) {
            int left = 0, right = monoLen;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (mono[mid] <= obstacles[i]) left = mid + 1;
                else right = mid;
            }
            res[i] = left + 1;
            if (left == monoLen) ++monoLen;
            mono[left] = obstacles[i];
        }
        return res;
    }

}
